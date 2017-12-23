/**
 * Created by woongs on 2017. 12. 17..
 */
import React from 'react';
import { Glyphicon } from 'react-bootstrap';
import BigCalendar from 'react-big-calendar';
import moment from 'moment';
import 'react-big-calendar/lib/css/react-big-calendar.css';
import className from 'classnames/bind';
import DateModal from './DateModal';
import axios from 'axios';

const cx = className.bind(require('./css/Calendar.css'));

BigCalendar.momentLocalizer(moment);

class DateCalendar extends React.Component {
  constructor() {
    super();

    let nowDate = new Date();
    this.state = {
      year: nowDate.getFullYear().toString(),
      month: (nowDate.getMonth() + 1).toString(),
      events: [],
      dateModal: false,
      date: ''
    };

    this.handleSelectEvent= this.handleSelectEvent.bind(this);
    this.modalClose = this.modalClose.bind(this);
    this.getDiaryTitleData = this.getDiaryTitleData.bind(this);
    this.getDiaryContentData = this.getDiaryContentData.bind(this);

    this.getDiaryTitleData(nowDate.getFullYear().toString(), (nowDate.getMonth() + 1).toString());
  }

  getDiaryTitleData(year, month) {
    axios.get('/calendar/diary/list', {
      params : {
        year: year,
        month: month
      }
    }).then((data) => {
      console.log(data);
      if (data === undefined || data.data === null || data.data == "") {
        return;
      }
      const convertedEvents = [];
      data.data.map((item, index) => (
        convertedEvents.push({
          title: item.title,
          start: new Date(item.year, item.month-1, item.day),
          end: new Date(item.year, item.month-1, item.day)
        })
      ));
      this.setState({
        events: convertedEvents
      })
    })
  }

  getDiaryContentData(year, month, day) {
    axios.get('/calendar/diary/', {
      params : {
        year: year,
        month: month,
        day: day
      }
    }).then((data) => {
      console.log(data.data);
      if (data === undefined || data.data === null || data.data == "") {
        return;
      }
      this.setState({
        title: data.data.title,
        content: data.data.content
      })
    })
  }

  formatDate(date) {
    var d = new Date(date),
      month = '' + (d.getMonth() + 1),
      day = '' + d.getDate(),
      year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    console.log([year, month, day].join('-'));

    return [year, month, day].join('-');
  }

  handleSelectEvent(slotInfo) {
    this.getDiaryContentData(slotInfo.start.getFullYear(), slotInfo.start.getMonth() + 1, slotInfo.start.getDate());
    this.setState({
      dateModal: true,
      date: this.formatDate(slotInfo.start)
    })
  }

  modalClose() {
    this.setState({
      dateModal: false,
      date: '',
      title: '',
      content: ''
    });
  }


  render(){
    return (
      <div className={cx('cx-calendar')}>
        <BigCalendar
          selectable
          events={this.state.events}
          onSelectSlot={(slotInfo) => this.handleSelectEvent(slotInfo)}
          views={['month']}
          style={{height: 800}}
          onNavigate={(date) => {
            this.getDiaryTitleData(date.getFullYear().toString(), (date.getMonth()+1).toString());
          }}
        />
        <DateModal
          showModal={this.state.dateModal}
          date={this.state.date}
          title={this.state.title}
          content={this.state.content}
        />
      </div>

    );
  }
}

export default DateCalendar;