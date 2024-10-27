package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.service.RandomService;
import racingcar.validator.InputValidator;
import racingcar.validator.RandomValidator;
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

    // 입력 값 검증
    List<String> carList = inputValidator.checkCarNames(carNames);    // 완료
    int parsedAtmp = inputValidator.isValidAtmp(numberOfAttempts);    // 완료

    // 경주 시작
    List<String> winnersList = racingCarService.startRace(carList, parsedAtmp);
    racingCarView.displayResults(winnersList);
  }


}
