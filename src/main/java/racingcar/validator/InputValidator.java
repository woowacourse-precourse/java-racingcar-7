package racingcar.validator;

import static racingcar.View.constant.ErrorMessage.TOO_LONG_VALUE;

import java.util.List;
import racingcar.global.exception.RacingcarException;

public class InputValidator {
    public void check(List<String> carNames) {
        carNames.stream()
                .forEach(this::checkStringLength);
    }

    public void checkStringLength(String input) {
        if (input.length() > 5) {
            throw new RacingcarException(TOO_LONG_VALUE);
        }
    }
}
