package racingcar.controller;

import java.util.List;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.util.CarNamesCreator;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {

    private final String inputCarNames = initializeCarNames();
    private final Long tryCount = initializeTryCount();
    private final Cars cars = registerCars();

    public void race() {
        executeRacing();
        announceWinners();
    }

    private String initializeCarNames() {
        String inputCarNames = InputView.promptInputCarNames();
        InputValidator.validateCarNames(inputCarNames);
        return inputCarNames;
    }

    private Long initializeTryCount() {
        return InputView.promptInputTryCount();
    }

    private Cars registerCars() {
        CarFactory carFactory = CarFactory.getInstance();
        return carFactory.createCars(CarNamesCreator.createCarNames(inputCarNames));
    }

    private void executeRacing() {
        ResultView.promptExecutionResult();

        for (long count = 1L; count <= tryCount; count++) {
            cars.takeTurn();
            ResultView.showTurnResult(cars);
        }
    }

    private void announceWinners() {
        List<String> winners = cars.findWinners();
        ResultView.showWinners(winners);
    }

}
