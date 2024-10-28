package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.MovingCarServiceImpl;
import racingcar.service.SeperateCarNameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RacingCarController racingCarController = new RacingCarController(new SeperateCarNameService(),
                                                                          new MovingCarServiceImpl(),
                                                                          new OutputView(),
                                                                          new InputView());

        racingCarController.run();

    }
}
