package racingcar.controller;


import static racingcar.view.InputView.UserInput;
import static racingcar.view.OutputView.printAttemptCountInputMessage;
import static racingcar.view.OutputView.printCarNamesInputMessage;

import racingcar.domain.CarGenerator;
import racingcar.domain.Cars;
import racingcar.validation.AttemptCountValidation;
import racingcar.validation.CarNameValidation;

public class RacingCarController {
    public void run() {
        Cars cars = getCars();
        int attemptCount = getAttemptCount();

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
}
