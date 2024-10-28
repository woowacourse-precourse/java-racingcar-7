package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        CarService carService = new CarService();
        RacingService racingService = new RacingService();

        RacingController racingController = new RacingController(inputView, carService, racingService);

        racingController.startRacing();
    }
}
