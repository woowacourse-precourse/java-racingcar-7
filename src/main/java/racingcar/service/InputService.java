package racingcar.service;

import racingcar.domain.CarNameParser;
import racingcar.util.ValidationUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.constant.ErrorMessages.*;

public class InputService {
    public List<String> getRacingCarNamesFromUser(){
        OutputView.printCarNameInputPrompt();
        String carNamesStr = InputView.readConsoleInput();
        CarNameParser carNameParser = new CarNameParser();
        return carNameParser.parse(carNamesStr);
    }

    public int getTrialCountFromUser() {
        OutputView.printTrialInputPrompt();
        String trialStr = InputView.readConsoleInput();
        validateTrial(trialStr);
        return Integer.parseInt(trialStr);
    }

    private void validateTrial(String trialStr) {
        if (!ValidationUtil.isInteger(trialStr) || Integer.parseInt(trialStr) <= 0) {
            throw new IllegalArgumentException(TRIAL_COUNT_ERROR_MESSAGE);
        }
    }
}
