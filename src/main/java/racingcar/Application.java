package racingcar;

import racingcar.controller.CarController;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarService carService = new CarService();

        CarController controller = new CarController(outputView, inputView, carService);
        controller.run();
    }
}
