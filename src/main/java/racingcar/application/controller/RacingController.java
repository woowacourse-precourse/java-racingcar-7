package racingcar.application.controller;

import java.util.List;
import racingcar.application.model.Car;
import racingcar.application.service.RacingService;
import racingcar.application.view.input.InputView;
import racingcar.application.view.output.OutputView;

public class RacingController {

  private final RacingService racingService;
  private final InputView inputView;
  private final OutputView outputView;

  public RacingController(RacingService racingService, InputView inputView, OutputView outputView) {
    this.racingService = racingService;
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public void initialize() {

    outputView.printCarNamesInputPrompt();
    String inputCarNames = inputView.readInputCarNames();

    outputView.printAttemptCountInputPrompt();
    int inputAttemptCount = inputView.readInputAttemptCount();

    racingService.setup(inputCarNames, inputAttemptCount);
  }

  public void startRace() {

    outputView.printStartMessage();

    for (int i = 0; i < racingService.getAttemptCount(); i++) {
      List<Car> currentRaceState = racingService.playRound();
      outputView.printRaceState(currentRaceState);
    }
  }
}
