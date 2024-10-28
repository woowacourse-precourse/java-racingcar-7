package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.NumberOfAttempt;
import racingcar.service.GameService;
import racingcar.validation.CarNamesValidator;
import racingcar.validation.NumberOfAttemptsValidator;
import racingcar.view.InputView;
import racingcar.view.constant.RunConstant;

import java.util.List;

public class GameController {

    Car car = new Car();
    NumberOfAttempt numberOfAttempt = new NumberOfAttempt();
    InputView inputView = new InputView();

    public void run() {
        saveInput();
        GameService gameService = new GameService(car, numberOfAttempt);
        gameService.showExecutionResult();
        gameService.showWinners();
    }

    private void saveInput() {
        String carNamesInput = inputView.CarNames();
        refineCarNamesInput(carNamesInput);

        String numberOfAttemptInput = inputView.NumberOfAttempt();
        refineNumberOfAttemptInput(numberOfAttemptInput);
    }

    private void refineCarNamesInput(String input) {
        String inputWithoutBlank = input.replace(", ", ",");
        List<String> splitCarNames = List.of(inputWithoutBlank.split(RunConstant.DELIMITER));

        CarNamesValidator validator = new CarNamesValidator();

        for (String carName : splitCarNames) {
            validator.validateCarNames(carName);
        }
        car.setCarNames(splitCarNames);
    }

    private void refineNumberOfAttemptInput(String input) {
        NumberOfAttemptsValidator validator = new NumberOfAttemptsValidator();
        validator.validateNumberOfAttempts(input);
        numberOfAttempt.setNumber(Integer.parseInt(input));
    }
}