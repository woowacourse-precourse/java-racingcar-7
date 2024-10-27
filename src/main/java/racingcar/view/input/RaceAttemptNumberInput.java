package racingcar.view.input;

import racingcar.util.RaceAttemptNumberValidator;

public class RaceAttemptNumberInput {
    public int process(String input) {
        return RaceAttemptNumberValidator.validate(input);
    }
}
