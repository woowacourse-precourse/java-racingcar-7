package controller;

import view.CarInputView;
import view.WinnerOutputView;

public class RacingcarController {
  private final CarInputView carInputView;
  private final WinnerOutputView winnerOutputView;

  public RacingcarController(){
    this.carInputView = new CarInputView();
    this.winnerOutputView = new WinnerOutputView();
  }
}
