import React from 'react';
import Calculator from '../containers/Calculator';
import { render, fireEvent } from '@testing-library/react';

describe('Calculator', () => {
  let container;
  beforeEach(() => {
    container = render(<Calculator />);
  });

  it('should change running total on number enter', () => {
    const button4 = container.getByTestId('number4');
    const runningTotal = container.getByTestId('running-total');
    fireEvent.click(button4);
    expect(runningTotal.textContent).toEqual('4');
  });

  it('should add 1 to 4 and get 5', () => {
    const runningTotal = container.getByTestId('running-total');
    expect(runningTotal.textContent).toEqual('0');
    const button1 = container.getByTestId('number1');
    const button4 = container.getByTestId('number4');
    const operatorAdd = container.getByTestId('operator-add');
    const operatorEquals = container.getByTestId('operator-equals');
    fireEvent.click(button1);
    expect(runningTotal.textContent).toEqual('1');
    fireEvent.click(operatorAdd);
    fireEvent.click(button4);
    fireEvent.click(operatorEquals);
    expect(runningTotal.textContent).toEqual('5');
  });

  it('should subtract 4 from 7 and get 3', () => {
    const runningTotal = container.getByTestId('running-total');
    expect(runningTotal.textContent).toEqual('0');
    const button4 = container.getByTestId('number4');
    const button7 = container.getByTestId('number7');
    const operatorSubtract = container.getByTestId('operator-subtract');
    const operatorEquals = container.getByTestId('operator-equals');
    fireEvent.click(button7);
    expect(runningTotal.textContent).toEqual('7');
    fireEvent.click(operatorSubtract);
    fireEvent.click(button4);
    fireEvent.click(operatorEquals);
    expect(runningTotal.textContent).toEqual('3');
  });

  it('should multiply 3 by 5 and get 15', () => {
    const runningTotal = container.getByTestId('running-total');
    expect(runningTotal.textContent).toEqual('0');
    const button3 = container.getByTestId('number3');
    const button5 = container.getByTestId('number5');
    const operatorMultiply = container.getByTestId('operator-multiply');
    const operatorEquals = container.getByTestId('operator-equals');
    fireEvent.click(button3);
    expect(runningTotal.textContent).toEqual('3');
    fireEvent.click(operatorMultiply);
    fireEvent.click(button5);
    fireEvent.click(operatorEquals);
    expect(runningTotal.textContent).toEqual('15');
  });

  it('should divide 21 by 7 and get 3', () => {
    const runningTotal = container.getByTestId('running-total');
    expect(runningTotal.textContent).toEqual('0');
    const button2 = container.getByTestId('number2');
    const button1 = container.getByTestId('number1');
    const button7 = container.getByTestId('number7');
    const operatorDivide = container.getByTestId('operator-divide');
    const operatorEquals = container.getByTestId('operator-equals');
    fireEvent.click(button2);
    fireEvent.click(button1);
    expect(runningTotal.textContent).toEqual('21');
    fireEvent.click(operatorDivide);
    fireEvent.click(button7);
    fireEvent.click(operatorEquals);
    expect(runningTotal.textContent).toEqual('3');
  });

  it('concatenate multiple number button clicks', () => {
    const runningTotal = container.getByTestId('running-total');
    expect(runningTotal.textContent).toEqual('0');
    const button9 = container.getByTestId('number9');
    const button2 = container.getByTestId('number2');
    const button4 = container.getByTestId('number4');
    const button7 = container.getByTestId('number7');
    const operatorDivide = container.getByTestId('operator-divide');
    const operatorEquals = container.getByTestId('operator-equals');
    fireEvent.click(button9);
    fireEvent.click(button2);
    fireEvent.click(button4);
    expect(runningTotal.textContent).toEqual('924');
    fireEvent.click(operatorDivide);
    fireEvent.click(button7);
    fireEvent.click(button7);
    fireEvent.click(operatorEquals);
    expect(runningTotal.textContent).toEqual('12');
  });
  it('chain multiple operations together', () => {
    const runningTotal = container.getByTestId('running-total');
    expect(runningTotal.textContent).toEqual('0');
    const button2 = container.getByTestId('number2');
    const operatorAdd = container.getByTestId('operator-add');
    const operatorMultiply = container.getByTestId('operator-multiply');
    const operatorEquals = container.getByTestId('operator-equals');
    fireEvent.click(button2);
    fireEvent.click(operatorAdd);
    fireEvent.click(operatorAdd);
    fireEvent.click(operatorAdd);
    expect(runningTotal.textContent).toEqual('6');
    fireEvent.click(operatorMultiply);
    expect(runningTotal.textContent).toEqual('10');
    fireEvent.click(operatorEquals);
    expect(runningTotal.textContent).toEqual('60');
  });
  it('clear the running total without affecting the calculation', () => {
    const runningTotal = container.getByTestId('running-total');
    expect(runningTotal.textContent).toEqual('0');
    const button2 = container.getByTestId('number2');
    const button4 = container.getByTestId('number4');
    const operatorClear = container.getByTestId('clear');
    const operatorAdd = container.getByTestId('operator-add');
    const operatorMultiply = container.getByTestId('operator-multiply');
    const operatorEquals = container.getByTestId('operator-equals');
    fireEvent.click(button2);
    fireEvent.click(operatorAdd);
    fireEvent.click(button2);
    fireEvent.click(operatorEquals);
    expect(runningTotal.textContent).toEqual('4');
    fireEvent.click(operatorClear);
    fireEvent.click(operatorClear);
    fireEvent.click(button4);
    fireEvent.click(operatorMultiply);
    fireEvent.click(button4);
    fireEvent.click(operatorEquals);
    expect(runningTotal.textContent).toEqual('16');
  });
});
