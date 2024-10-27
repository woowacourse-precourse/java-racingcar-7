package racingcar.application.controller;

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
}
