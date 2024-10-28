package racingcar.validation;

public class InputValidator {

    public static void validateCarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("Car name must not be empty.");
        }
        if (!carName.matches("^[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("Car name must only contain alphanumeric characters.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name must not exceed 5 characters.");
        }
    }


    public static int validateAttemptCount(String attemptCountInput) {
        int attemptCount;
        try {
            attemptCount = Integer.parseInt(attemptCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Attempt count must be a valid number.");
        }
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("Attempt count must be greater than zero.");
        }
        return attemptCount;
    }
}
