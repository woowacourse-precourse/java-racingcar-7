package racingcar.controller;

import java.util.List;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.util.CarNamesCreator;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
    public static void race() {
        String inputCarNames = InputView.promptInputCarNames();
        InputValidator.validateCarNames(inputCarNames);
        long tryCount = InputView.promptInputTryCount();

        CarFactory carFactory = CarFactory.getInstance();
        Cars cars = carFactory.createCars(CarNamesCreator.createCarNames(inputCarNames));

        ResultView.promptExecutionResult();
        for (long count = 1L; count <= tryCount; count++) {
            cars.takeTurn();
            ResultView.showTurnResult(cars);
        }

        List<String> winners = cars.findWinners();
        ResultView.showWinners(winners);
    }

}
