package racingcar.exception;

public final class InputValidation {

    private static final String BLANK = " ";

    private InputValidation() {
    }

    public static void validateCarNames(String carNames) {
        if (validateNullOrEmpty(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_REQUIRED.getMessage());
        }
        if (validateBlank(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BLANK.getMessage());
        }
    }

    public static void validateDelimiter(String[] splitCarNames) {
        for (String splitCarName : splitCarNames) {
            if (validateNullOrEmpty(splitCarName)) {
                throw new IllegalArgumentException(ErrorMessage.SEQUENCE_DELIMITER.getMessage());
            }
        }
    }

    public static void validateTryCount(String tryCount) {
        if (validateNullOrEmpty(tryCount)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_REQUIRED.getMessage());
        }
        if (validateBlank(tryCount)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BLANK.getMessage());
        }
    }

    private static boolean validateNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean validateBlank(String input) {
        return input.contains(BLANK);
    }
}
