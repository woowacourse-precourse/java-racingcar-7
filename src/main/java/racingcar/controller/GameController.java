package racingcar.controller;

import racingcar.validation.BlankNameValidator;
import racingcar.validation.NameLengthValidator;
import racingcar.validation.TrialTimesValidator;
import racingcar.view.InputView;

import java.util.ArrayList;

public class GameController {

    public static void run() {
        ArrayList<String> carNames = InputView.getCarNames();
        String trialTimes = InputView.getTrialTimes();
        validateNameInput(carNames);
        validateTrialTimesInput(trialTimes);
    }

    private static void validateNameInput(ArrayList<String> carNames) {
        BlankNameValidator.validate(carNames);
        NameLengthValidator.validate(carNames);
    }

    private static void validateTrialTimesInput(String trialTimes) {
        TrialTimesValidator.validate(trialTimes);
    }
}
