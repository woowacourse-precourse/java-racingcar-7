package racingcar;

import java.util.List;
import java.util.Arrays;

public class RacingGameInputValidator {
    private static final String DELIMITER = ",";
    private static final String EMPTY_INPUT_ERROR = "자동차 이름을 입력해주세요.";
    private static final String EMPTY_NAME_ERROR = "빈 이름이 포함되어 있습니다.";
    private static final String INVALID_NAME_ERROR = "자동차 이름은 영문자, 숫자, 한글만 사용할 수 있습니다.";
    private static final String NAME_LENGTH_ERROR = "자동차 이름은 5자 이하여야 합니다.";
    private static final String CAR_COUNT_ERROR = "자동차는 20대를 초과할 수 없습니다.";
    private static final String TRY_COUNT_ERROR = "시도 횟수는 30회를 초과할 수 없습니다.";
    private static final String VALID_NAME_PATTERN = "^[a-zA-Z0-9가-힣]+$";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_CAR_COUNT = 20;
    private static final int MAX_TRY_COUNT = 30;

    public static List<String> parseCarNames(String input) {
        validateInput(input);
        List<String> names = Arrays.asList(input.split(DELIMITER));
        validateCarCount(names);
        validateNames(names);
        return names;
    }

    private static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    private static void validateCarCount(List<String> names) {
        if (names.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR);
        }
    }

    private static void validateNames(List<String> names) {
        for (String name : names) {
            validateName(name.trim());
        }
        validateDuplicateNames(names);
    }

    private static void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
        if (!name.matches(VALID_NAME_PATTERN)) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private static void validateDuplicateNames(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static int validateTryCount(String input) {
        int tryCount = validateNumeric(input);
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        if (tryCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR);
        }
        return tryCount;
    }

    private static int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}