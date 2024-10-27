package racingcar.controller;

import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class RacingController {
    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();


    public void startGame() {

        String names = inputView.readName();
        String tryNumber = inputView.readTryNumber();
        inputValidator.validate(names, tryNumber);


    }
}
