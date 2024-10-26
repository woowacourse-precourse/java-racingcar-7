package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Extractor;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ApplicationController {

    private final CarController carController;
    private final Extractor extractor;
    private final Validator validator;
    private final InputView inputView;
    private final OutputView outputView;

    public ApplicationController(CarController carController, Extractor extractor, Validator validator,
                                 InputView inputView, OutputView outputView) {
        this.carController = carController;
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
            carController.moveOrStopCarsByRandomNumber(cars);
            outputView.printEachRound(cars);
        }

        Cars winners = carController.getWinners(cars.getCarList());
        outputView.printWinnersName(winners);
    }

    private Cars getCars(String input) {
        Cars cars = extractor.extractCars(input);
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
