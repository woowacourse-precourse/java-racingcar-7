package racingcar.validator;

import java.util.HashSet;
import java.util.List;

public class RaceCarsValidator {
    private static final String ERROR_DUPLICATE_NAME = "중복된 자동차 이름을 허용하지 않습니다.";
    private static final String ERROR_CAR_COUNT = "자동차는 최소 1개 이어야 합니다.";
    private static final int MIN_CAR_COUNT = 1;

    private RaceCarsValidator() {
    }

    public static void validate(List<String> names) {
        validateDuplicateNames(names);
        validateRaceCarCount(names);
    }

    private static void validateDuplicateNames(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

    private static void validateRaceCarCount(List<String> names) {
        if (names.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ERROR_CAR_COUNT);
        }
    }
}
