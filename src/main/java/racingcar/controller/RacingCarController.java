package racingcar.controller;

import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;
    private final CarService carService;

    public RacingCarController(InputView inputView, CarService carService) {
        this.inputView = inputView;
        this.carService = carService;
    }

    public void run() {
        inputView.printCarNameInputMessage();
        Set<String> carNames = InputValidator.validateCarNameInput(inputView.getInput());

        inputView.printRoundCountInputMessage();
        int roundCount = InputValidator.validateRoundCountInput(inputView.getInput());

        List<Car> cars = carService.createCars(carNames);
    }
}
