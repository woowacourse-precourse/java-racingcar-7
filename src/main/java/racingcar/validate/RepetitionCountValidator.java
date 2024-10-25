package racingcar.validate;

import racingcar.ErrorMessage;

public abstract class RepetitionCountValidator {

    private static void validateIsNumber(String count) {
        if (!count.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(
                ErrorMessage.REPETITION_COUNT_NOT_A_NUMBER.getMessage());
        }
    }

    private static void validateIsPositive(String count) {
        int repetitionCount = Integer.parseInt(count);

        if (repetitionCount <= 0) {
            throw new IllegalArgumentException(
                ErrorMessage.REPETITION_COUNT_NOT_NEGATIVE.getMessage());
        }
    }

    private static void validateIsNotBlank(String count) {
        if (count == null || count.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.REPETITION_COUNT_IS_BLANK.getMessage());
        }
    }

    public static void validateRepetitionCount(String count) {
        validateIsNotBlank(count);
        validateIsNumber(count);
        validateIsPositive(count);
    }
}
