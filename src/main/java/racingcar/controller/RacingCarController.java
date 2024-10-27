package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.validator.InputValidator;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarController {
  private final RacingCarView racingCarView;
  private final InputValidator inputValidator;
  private final RacingCarService racingCarService;

  public RacingCarController() {
    this.racingCarView = new RacingCarView();
    this.inputValidator = new InputValidator();
    this.racingCarService = new RacingCarService();
  }
  public void startRace() {
    String carNames = racingCarView.inputCarNames();
    String numberOfAttempts = racingCarView.inputNumberOfAttempts();

    List<String> carList = inputValidator.checkCarNames(carNames);
    int parsedAtmp = inputValidator.isValidAtmp(numberOfAttempts);

    List<String> winnersList = racingCarService.startRace(carList, parsedAtmp);
    racingCarView.displayResults(winnersList);
  }


}
