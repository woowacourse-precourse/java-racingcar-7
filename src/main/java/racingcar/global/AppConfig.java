package racingcar.global;

import racingcar.application.RacingCarService;
import racingcar.domain.car.CarRepository;
import racingcar.presentation.Controller;

public class AppConfig {

    public AppConfig() {
        Controller controller = getController();

        controller.addCars();
        controller.startRace();
    }

    public static void start() {
        new AppConfig();
    }

    private Controller getController() {
        return new Controller(getService());
    }

    private RacingCarService getService() {
        return new RacingCarService(getCarRepository());
    }

    private CarRepository getCarRepository() {
        return new CarRepository();
    }
}
