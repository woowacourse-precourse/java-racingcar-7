package racingcar;

import static racingcar.ConstantMessage.BE_DIGIT;
import static racingcar.ConstantMessage.BE_NATURAL_NUMBER;
import static racingcar.ConstantMessage.INPUT_IS_EMPTY;

public class ValidateCount {
    public static void validateInputCount(String userInputCount) {
        if (userInputCount == null || userInputCount.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY);
        }

        try {
            int count = Integer.parseInt(userInputCount);
            if (count <= 0) {
                throw new IllegalArgumentException(BE_NATURAL_NUMBER);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BE_DIGIT);
        }
    }
}
