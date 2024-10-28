package racingcar.controller;

import racingcar.validation.BlankNameValidator;
import racingcar.validation.NameLengthValidator;
import racingcar.view.InputView;

import java.util.ArrayList;

public class GameController {

    public static void run() {
        ArrayList<String> carNames = InputView.getCarNames();
        int trialTimes = InputView.getTrialTimes();
        validateNameInput(carNames);
    }

    private static void validateNameInput(ArrayList<String> carNames) {
        BlankNameValidator.validate(carNames);
        NameLengthValidator.validate(carNames);
    }
}
