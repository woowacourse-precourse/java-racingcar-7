package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingGameServiceInterface;
import racingcar.view.InputViewInterface;
import racingcar.view.ResultViewInterface;

import java.util.List;

public class RacingGameController {

  private final RacingGameServiceInterface racingGameService;
  private final InputViewInterface inputView;
  private final ResultViewInterface resultView;

  public RacingGameController(
      RacingGameServiceInterface racingGameService,
      InputViewInterface inputView,
      ResultViewInterface resultView
  ) {
    this.racingGameService = racingGameService;
    this.inputView = inputView;
    this.resultView = resultView;
  }

  public void run() {
    String[] carNames = inputView.inputCarNames();
    int trialCount = inputView.inputTrialCount();

    racingGameService.validateCarNames(carNames);
    racingGameService.validateTrialCount(trialCount);

    List<Car> cars = racingGameService.createCars(carNames);

    for (int i = 0; i < trialCount; i++) {
      racingGameService.playRound(cars);
      resultView.printRoundResult(cars);
    }

    List<Car> winners = racingGameService.findWinners(cars);
    resultView.printWinners(winners);
  }
}
