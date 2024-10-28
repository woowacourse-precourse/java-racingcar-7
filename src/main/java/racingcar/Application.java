package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.CarService;
import racingcar.service.RacingService;


public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService();
        RacingService racingService = new RacingService();

        RacingController racingController = new RacingController(carService, racingService);

        racingController.startRacing();
    }
}
