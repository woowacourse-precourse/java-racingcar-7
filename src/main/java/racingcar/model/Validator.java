package racingcar.model;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateInputString(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRoundCount(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }
    }
}
