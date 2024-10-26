package racingcar.config;

import racingcar.controller.CarController;
import racingcar.controller.Controller;
import racingcar.controller.InputController;
import racingcar.controller.OutputController;
import racingcar.controller.RaceController;
import racingcar.service.CarService;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;
    private final RaceService raceService;

    public AppConfig() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carService = new CarService();
        this.raceService = new RaceService();
    }

    public InputController createInputController() {
        return new InputController(inputView);
    }

    public OutputController createOutputController() {
        return new OutputController(outputView);
    }

    public CarController createCarController() {
        return new CarController(carService);
    }

    public RaceController createRaceController() {
        return new RaceController(raceService, outputView);
    }

    public Controller createController() {
        return new Controller();
    }
}
