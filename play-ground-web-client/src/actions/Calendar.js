export const YEAR_INCREMENT = 'YEAR_INCREMENT';
export const YEAR_DECREMENT = 'YEAR_DECREMENT';
export const MONTH_INCREMENT = 'MONTH_INCREMENT';
export const MONTH_DECREMENT = 'MONTH_DECREMENT';

export function yearIncrement() {
  return {
      type: YEAR_INCREMENT
  };
}

export function yearDecrement() {
  return {
      type: YEAR_DECREMENT
  };
}

export function monthIncrement() {
  return {
    type: MONTH_INCREMENT
  };
}

export function monthDecrement() {
  return {
    type: MONTH_DECREMENT
  };
}