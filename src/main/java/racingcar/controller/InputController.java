package racingcar.controller;

import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class InputController {
  private final InputView inputView;
  private final InputValidator inputValidator;

  public InputController(InputView inputView, InputValidator inputValidator) {
    this.inputView = inputView;
    this.inputValidator = inputValidator;
  }
  public void run() {
    String carNameInput = inputView.askForCarName();
    inputValidator.validateCarNameInput(carNameInput);
    String attemptsInput = inputView.askForAttempts();
    inputValidator.validateAttemptsInput(attemptsInput);
  }
}