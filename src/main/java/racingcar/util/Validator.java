package racingcar.util;

import java.util.HashSet;
import java.util.List;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        if (!areValidName(carNames)) {
            throw new IllegalArgumentException(Message.INVALID_CAR_NAME_LENGTH);
        }
        if (isNameOverlap(carNames)) {
            throw new IllegalArgumentException(Message.DUPLICATE_CAR_NAME);
        }
    }

    public static void validateRoundCount(String rawRoundInput) {
        if (!isValidRoundCount(rawRoundInput)) {
            throw new IllegalArgumentException(Message.INVALID_ROUND_COUNT);
        }
    }

    private static boolean areValidName(List<String> carNames) {
        return carNames.stream().allMatch(name -> name.length() <= MAX_NAME_LENGTH);
    }

    private static boolean isNameOverlap(List<String> carNames) {
        return carNames.size() != new HashSet<>(carNames).size();
    }

    private static boolean isValidRoundCount(String rawRoundInput) {
        return rawRoundInput.matches("\\d+");
    }
}
