package racingcar.controller;


import static racingcar.view.InputView.UserInput;
import static racingcar.view.OutputView.printAttemptCountInputMessage;
import static racingcar.view.OutputView.printCarNamesInputMessage;
import static racingcar.view.OutputView.printExecutionResult;
import static racingcar.view.OutputView.printFinalWinner;

import java.util.List;
import racingcar.domain.CarGenerator;
import racingcar.domain.Cars;
import racingcar.validation.AttemptCountValidation;
import racingcar.validation.CarNameValidation;

public class RacingCarController {
    public void run() {
        Cars cars = getCars();
        int attemptCount = getAttemptCount();
        racing(cars, attemptCount);
        showWinner(cars);
    }


    private Cars getCars() {
        printCarNamesInputMessage();
        String carNames = UserInput();
        CarNameValidation.validate(carNames);
        return new Cars(CarGenerator.getParticipateCars(carNames));
    }

    private int getAttemptCount() {
        printAttemptCountInputMessage();
        String attemptCount = UserInput();
        AttemptCountValidation.validate(attemptCount);
        return Integer.parseInt(attemptCount);
    }

    private void racing(Cars cars, int attemptCount) {
        printExecutionResult();
//        i 이름 변경
        for (int i = 0; i < attemptCount; i++) {
            cars.move();
        }
    }

    private void showWinner(Cars cars) {
        printFinalWinner();
        List<String> winnerNames = cars.calculateFinalWinner();
        String result = String.join(", ", winnerNames);
        System.out.println(result);
    }
}
