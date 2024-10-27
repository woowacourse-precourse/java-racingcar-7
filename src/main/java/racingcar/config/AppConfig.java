package racingcar.config;

import racingcar.controller.CarController;
import racingcar.controller.Controller;
import racingcar.controller.InputController;
import racingcar.controller.OutputController;
import racingcar.controller.RaceController;
import racingcar.service.CarService;
import racingcar.service.RaceService;
import racingcar.validate.CarValidator;
import racingcar.validate.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;
    private final RaceService raceService;
    private final InputValidator inputValidator;
    private final CarValidator carValidator;

    public AppConfig() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carService = new CarService();
        this.raceService = new RaceService();
        this.inputValidator = new InputValidator();
        this.carValidator = new CarValidator();
    }

    public InputController createInputController() {
        return new InputController(inputView, inputValidator);
    }

    public OutputController createOutputController() {
        return new OutputController(outputView);
    }

    public CarController createCarController() {
        return new CarController(carService, carValidator);
    }

    public RaceController createRaceController() {
        return new RaceController(raceService, outputView);
    }

    public Controller createController() {
        return new Controller(createInputController(), createOutputController(), createCarController(),
                createRaceController());
    }
}
