package racingcar.service;

import static racingcar.common.Constants.DUPLICATED_CAR_NAMES;
import static racingcar.common.Constants.INVALID_CAR_NAME;
import static racingcar.common.Constants.INVALID_GAME_COUNT;
import static racingcar.common.Constants.ONLY_POSITIVE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationService {

    public static void validateCarNameDuplicate (List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);

        if (uniqueCarNames.size() < carNames.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAMES);
        }
    }

    public static void validateCarName (String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
    }

    public static void validateGameCount (String rawGameCount) {
        if (!isPositive(rawGameCount)) {
            throw new IllegalArgumentException(INVALID_GAME_COUNT);
        }
    }

    private static boolean isPositive (String rawGameCount) {
        return rawGameCount.matches(ONLY_POSITIVE);
    }
}
