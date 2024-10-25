package racingcar.controller;

import racingcar.validation.blankNameValidator;
import racingcar.validation.nameLengthValidator;
import racingcar.error.ErrorMessage;
import racingcar.view.InputView;

import java.util.ArrayList;

public class GameController {

    public static void run() {
        ArrayList<String> carNames = InputView.getCarNames();
        int trialTimes = InputView.getTrialTimes();
        validateNameInput(carNames);
    }

    private static void validateNameInput(ArrayList<String> carNames) {
        blankNameValidator.validate(carNames);
        nameLengthValidator.validate(carNames);
    }
}
