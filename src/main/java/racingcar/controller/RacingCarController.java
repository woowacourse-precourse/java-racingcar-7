package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {

  private String inputCar;

  private Integer inputCount;

  public RacingCarController() {
    inputCar = inputCarStr();
    inputCount = inputCount();
  }

  public void run(){

  }

  private String inputCarStr() {
    return InputView.inputCarStr();
  }

  private  Integer inputCount() {
    return InputView.inputCount();
  }

}
