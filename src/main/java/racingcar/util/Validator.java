package racingcar.util;

import static racingcar.util.ConstantData.INPUT_DELIMITER;
import static racingcar.util.ConstantData.NAME_LENGTH_LIMIT;
import static racingcar.util.Message.DELIMITER_POSITION_INCORRECT;
import static racingcar.util.Message.NAME_LENGTH_NOT_VALID;

public class Validator {

    private Validator() {
    }

    public static void validateOneName(String name) {
        if (name.isBlank() || name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(DELIMITER_POSITION_INCORRECT);
        }
    }

    public static void validateInputString(String input) {
        if (input.startsWith(INPUT_DELIMITER) || input.endsWith(INPUT_DELIMITER)) {
            throw new IllegalArgumentException(NAME_LENGTH_NOT_VALID);
        }
    }

    public static int validateInteger(String trialCount) {
        try {
            return Integer.parseInt(trialCount);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(e.getMessage(), e.fillInStackTrace());
        }
    }
}
