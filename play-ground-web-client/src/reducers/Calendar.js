import { combineReducers } from 'redux'
import { YEAR_INCREMENT, YEAR_DECREMENT, MONTH_INCREMENT, MONTH_DECREMENT } from '../actions/Calendar'

let initialState = {
  year: 0,
  month: 0,
  day: 0,
  diff: 1
};

const calendar = (state=initialState, action) => {
  switch (action.type) {
    case YEAR_INCREMENT:
      return Object.assign({}, state, {
        year: state.year + state.diff
      });
    case YEAR_DECREMENT:
      return Object.assign({}, state, {
        year: state.year - state.diff
      });
    case MONTH_INCREMENT:
      return Object.assign({}, state, {
        year: state.month + state.diff
      });
    case MONTH_DECREMENT:
      return Object.assign({}, state, {
        year: state.month - state.diff
      });
    default:
      return state
  }
};

const calendarReducer = combineReducers({
  calendar
});

export default calendarReducer