package racingcar.model.attemptcountinput;

import racingcar.exception.AttemptCountNotNumberException;
import racingcar.exception.NegativeAttemptCountException;

public class AttemptCountValidation {
    public static int attemptCountValidation(String attemptCount) {
        try {
            int attemptCountNumber = Integer.parseInt(attemptCount);
            if (attemptCountNumber <= 0) {
                throw new NegativeAttemptCountException();
            }
            return attemptCountNumber;
        } catch (NumberFormatException e) {
            throw new AttemptCountNotNumberException();
        }
    }
}
