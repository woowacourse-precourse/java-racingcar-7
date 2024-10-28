package racingcar.common;

import java.util.List;

public class Validator {

    private Validator() {

    }

    public static void validateCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicated(carNames)) {
            throw new IllegalArgumentException();
        }
        for (String name : carNames) {
            if (name.length() < Limit.MIN_NAME_LENGTH || name.length() > Limit.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean hasDuplicated(List<String> items) {
        return items.size() != items.stream().distinct().count();
    }

    public static void validateRoundCount(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException();
        }
    }
}
