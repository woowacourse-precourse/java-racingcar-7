package racingcar.controller;


import static racingcar.view.InputView.UserInput;
import static racingcar.view.OutputView.printCarNamesInputMessage;

import racingcar.domain.CarGenerator;
import racingcar.domain.Cars;
import racingcar.validation.CarNameValidation;

public class RacingCarController {
    public void run() {

        Cars cars = getCars();

    }

    private Cars getCars() {
        printCarNamesInputMessage();
        String carNames = UserInput();
        CarNameValidation.validate(carNames);
        return new Cars(CarGenerator.getParticipateCars(carNames));
    }

}
