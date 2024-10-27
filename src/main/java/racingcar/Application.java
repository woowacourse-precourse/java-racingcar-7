package racingcar;

import racingcar.common.InputValidator;
import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.util.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.vo.CarFactory;

public class Application {
    public static void main(String[] args) {

        RacingGameController racingGameController = new RacingGameController(
                new InputView(),
                new InputValidator(),
                new CarFactory(),
                new RacingGameService(new RandomGenerator()),
                new OutputView()
        );

        racingGameController.run();

    }
}
