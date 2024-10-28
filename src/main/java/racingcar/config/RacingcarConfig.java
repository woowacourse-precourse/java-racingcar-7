package racingcar.config;

import racingcar.controller.CarController;
import racingcar.service.CarService;
import racingcar.service.impl.CarServiceImpl;
import racingcar.viewer.Output;
import racingcar.viewer.Viewer;

public class RacingcarConfig {

    private static final Output output = new Output();
    private static final Viewer viewer = new Viewer(output);
    private static final CarService carService = new CarServiceImpl(output);
    private static final CarController carController = new CarController(carService, viewer);

    private RacingcarConfig() {
    }

    public static CarService carService() {
        return carService;
    }

    public static Viewer viewer() {
        return viewer;
    }

    public static CarController carController() {
        return carController;
    }
}

