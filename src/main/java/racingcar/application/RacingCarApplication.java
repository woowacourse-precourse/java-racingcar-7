package racingcar.application;

import racingcar.application.controller.RacingController;
import racingcar.application.service.RacingService;
import racingcar.application.view.input.InputView;
import racingcar.application.view.input.InputViewImpl;
import racingcar.application.view.output.OutputView;
import racingcar.application.view.output.OutputViewImpl;

public class RacingCarApplication {

  public void run() {
    RacingService racingService = new RacingService();
    InputView inputView = new InputViewImpl();
    OutputView outputView = new OutputViewImpl();

    RacingController racingController = new RacingController(
        racingService,
        inputView,
        outputView
    );
  }
}
