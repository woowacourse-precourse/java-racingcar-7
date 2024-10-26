package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarGameService;
import racingcar.service.SeperateCarNameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RacingCarController racingCarController = new RacingCarController(new SeperateCarNameService(),
                                                                          new RacingCarGameService(),
                                                                          new OutputView(),
                                                                          new InputView());

        racingCarController.run();

    }
}
