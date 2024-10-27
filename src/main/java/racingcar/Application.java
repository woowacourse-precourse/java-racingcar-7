package racingcar;

import racingcar.controller.Racing;
import racingcar.service.CarService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        CarService carService = new CarService();

        Racing racing = new Racing(inputView, carService);

        racing.ready();
    }
}
