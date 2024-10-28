package racingcar;

import java.util.List;

public class Validator {
    private static final String VALID_ROUND = "^([1-9][0-9]*)$";
    private static final int NAME_MAX_LENGTH = 5;

    public static void validateName(List<String> carNames) {
        for (String carName : carNames) {
            if (isNullOrEmpty(carName) || !isValidLength(carName)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isNullOrEmpty(String carName) {
        return carName == null || carName.isEmpty();
    }

    private static boolean isValidLength(String carName) {
        return carName.length() <= NAME_MAX_LENGTH;
    }

    public static void validateRound(String round) {
        if (!round.matches(VALID_ROUND)) {
            throw new IllegalArgumentException();
        }
    }
}
