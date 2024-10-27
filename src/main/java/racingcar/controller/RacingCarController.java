package racingcar.controller;

import racingcar.validator.InitialInputValidator;
import racingcar.view.InputView;

public class RacingCarController {
  private final InputView inputView;
  private final InitialInputValidator inputValidator;

  public RacingCarController(InputView inputView, InitialInputValidator inputValidator) {
    this.inputView = inputView;
    this.inputValidator = inputValidator;
  }
  public void run() {
    String carNameInput = inputView.askForCarName();
    inputValidator.validateCarNameInput(carNameInput.trim());
    String attemptsInput = inputView.askForAttempts();
    inputValidator.validateAttemptsInput(attemptsInput.trim());
  }
}