package racingcar;

import racingcar.controller.CarController;
import racingcar.service.CarService;
import racingcar.util.InputView;
import racingcar.util.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarController carController = new CarController(new CarService(), new InputView(), new OutputView());
        carController.run();
    }
}
