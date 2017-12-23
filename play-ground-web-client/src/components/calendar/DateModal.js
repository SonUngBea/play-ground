/**
 * Created by woongs on 2017. 12. 17..
 */
import React from 'react';
import className from 'classnames/bind';
import { Glyphicon, Modal } from 'react-bootstrap';

const cx = className.bind(require('./css/DateModal.css'));

class DateModal extends React.Component {

  props: {
    showModal: boolean,
    date: string,
    title: string,
    content: string
  };

  render(){
    const {showModal, date, title, content} = this.props;
    return (
      <Modal show={showModal}>
        <Modal.Header closeButton>
          <div>
            {date}
          </div>
          <div>
            {title}
          </div>
        </Modal.Header>
        <Modal.Body>
          <div>
            {content}
          </div>
        </Modal.Body>
        <Modal.Footer>

        </Modal.Footer>
      </Modal>
    );
  }
}

export default DateModal;