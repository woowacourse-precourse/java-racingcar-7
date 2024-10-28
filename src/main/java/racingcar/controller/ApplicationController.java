package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.service.CarService;
import racingcar.service.Extractor;
import racingcar.service.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ApplicationController {

    private final CarService carService;
    private final Extractor extractor;
    private final Validator validator;
    private final InputView inputView;
    private final OutputView outputView;

    public ApplicationController(CarService carService, Extractor extractor, Validator validator,
                                 InputView inputView, OutputView outputView) {
        this.carService = carService;
        this.extractor = extractor;
        this.validator = validator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String input = getCarNames();

        Cars cars = getCars(input);

        long number = validator.validateRoundNumber(inputView.inputNumber());
        for (long i = 0; i < number; i++) {
            carService.moveOrStopCarsByRandomNumber(cars);
            outputView.printEachRound(cars);
        }

        Cars winners = carService.getWinners(cars.getCarList());
        outputView.printWinnersName(winners);
    }

    private Cars getCars(String input) {
        List<String> carNames = extractor.getCarNames(input);
        validator.validateDuplicatedCarName(carNames);

        Cars cars = extractor.extractCars(carNames);
        validator.validateCountOfCars(cars);
        validator.validateCarNameLength(cars);
        return cars;
    }

    private String getCarNames() {
        String input = inputView.inputString();
        validator.validateIsEmpty(input);
        return input;
    }
}
