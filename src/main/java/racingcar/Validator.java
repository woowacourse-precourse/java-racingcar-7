package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력값은 빈 값일 수 없습니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String DUPLICATE_NAME_ERROR_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private static final String INVALID_TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 양의 정수여야 합니다.";
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> names) {
        validateNotEmpty(names);
        validateNameLength(names);
        validateDuplicateNames(names);
    }


    private static void validateNotEmpty(List<String> names) {
        if (names == null || names.isEmpty() || names.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateNameLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicateNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    public static void validateTryCount(String input) {
        try {
            int tryCount = Integer.parseInt(input);

            if (tryCount <= 0) {
                throw new IllegalArgumentException(INVALID_TRY_COUNT_ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_ERROR_MESSAGE);
        }
    }
}
