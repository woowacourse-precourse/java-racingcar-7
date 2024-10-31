package racingcar;

import racingcar.back.controller.CarRaceController;
import racingcar.back.service.impl.CarRaceGameRunnerServiceImpl;
import racingcar.front.view.InputView;
import racingcar.front.view.OutputView;
import racingcar.global.frontcontroller.FrontController;

public class Application {
    public static void main(String[] args) {
        FrontController frontController = new FrontController(new InputView(), new OutputView(),
                new CarRaceController(new CarRaceGameRunnerServiceImpl()));

        frontController.run();
    }
}
