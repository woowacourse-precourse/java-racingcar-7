package racingcar.exception;

public final class InputValidation {

    private static final String BLANK = " ";

    private InputValidation() {
    }

    public static void validateCarNames(String carNames) {
        validate(carNames, ErrorMessage.CAR_NAME_REQUIRED.getMessage());
    }

    public static void validateDelimiter(String[] splitCarNames) {
        for (String splitCarName : splitCarNames) {
            validate(splitCarName, ErrorMessage.SEQUENCE_DELIMITER.getMessage());
        }
    }

    public static void validateTryCount(String tryCount) {
        validate(tryCount, ErrorMessage.TRY_COUNT_REQUIRED.getMessage());
    }

    private static void validate(String input, String exceptionMessage) {
        if (InputValidation.validateNullOrEmpty(input)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
        if (InputValidation.validateBlank(input)) {
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
