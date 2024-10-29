package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

  public static void main(String[] args) {
    RacingGameService racingGameService = new RacingGameService();
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    RacingGameController controller = new RacingGameController(
        racingGameService, inputView, resultView);
    controller.run();
  }
}
