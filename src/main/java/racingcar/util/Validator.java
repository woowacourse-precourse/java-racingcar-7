package racingcar.util;

import static racingcar.util.ConstantData.INPUT_DELIMITER;
import static racingcar.util.ConstantData.MINIMUM_RACING_CAR_NEEDED;
import static racingcar.util.ConstantData.NAME_LENGTH_LIMIT;
import static racingcar.util.Message.DELIMITER_POSITION_INCORRECT;
import static racingcar.util.Message.NAME_LENGTH_NOT_VALID;
import static racingcar.util.Message.NEED_MULTIPLE_RACING_CAR;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public static List<String> validateInputString(String input) {
        if (input.isBlank() || input.startsWith(INPUT_DELIMITER) || input.endsWith(INPUT_DELIMITER)) {
            throw new IllegalArgumentException(DELIMITER_POSITION_INCORRECT);
        }
        return Arrays.stream(input.split(INPUT_DELIMITER))
                .map(String::strip)
                .toList();
    }

    public static void validateNameCount(int nameCount) {
        if (nameCount < MINIMUM_RACING_CAR_NEEDED) {
            throw new IllegalArgumentException(NEED_MULTIPLE_RACING_CAR);
        }
    }

    public static void validateNameLength(String name) {
        if (name.isBlank() || name.length() > NAME_LENGTH_LIMIT) {
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
