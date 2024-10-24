package racingcar.exception;

public class InvalidInputException {
    public static void validateInput(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }
    }
}
