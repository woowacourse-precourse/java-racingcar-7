package racingcar.controller;

import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.Result;
import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;
    private final CarService carService;
    private final RacingService racingService;

    public RacingCarController(InputView inputView, CarService carService, RacingService racingService) {
        this.inputView = inputView;
        this.carService = carService;
        this.racingService = racingService;
    }

    public void run() {
        inputView.printCarNameInputMessage();
        Set<String> carNames = InputValidator.validateCarNameInput(inputView.getInput());

        inputView.printRoundCountInputMessage();
        int roundCount = InputValidator.validateRoundCountInput(inputView.getInput());

        List<Car> cars = carService.createCars(carNames);
        List<Result> results = racingService.startRace(cars, roundCount);
    }
}
