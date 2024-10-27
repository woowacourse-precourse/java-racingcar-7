package racingcar.utils;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InputValidator {
    public static final int MAX_NAME_LENGTH = 5;
    public static final String CAR_NAME_REGEX = "^[a-zA-Z0-9, 가-힣]+$";
    public static final String TRY_COUNT_REGEX = "^[0-9]+$";
    public static final String ERROR_INVALID_NAME_FORMAT = "적절하지 않은 이름 형식입니다.";
    public static final String ERROR_EXCEED_NAME_LENGTH = "이름의 제한 길이(5글자)를 초과하였습니다.";
    public static final String ERROR_DUPLICATE_NAMES = "중복되는 이름이 존재합니다.";
    private static final String ERROR_NOT_NUMBER = "시도 횟수는 자연수만 입력 가능합니다.";
    private static final String ERROR_OUT_OF_INT_RANGE = "시도 횟수가 int 범위를 초과했습니다.";
    private static final String ERROR_MINUS_NUMBER = "시도 횟수는 음수일 수 없습니다..";

    public static void validateName(String name) {
        validateNameFormat(name);
        validateNameLength(name);
    }

    public static void validateDuplicates(List<String> names) {
        Set<String> nameSet = new HashSet<>();
        List<String> duplicateNames = names.stream()
                .filter(name -> !nameSet.add(name))
                .toList();

        if (!duplicateNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAMES);
        }
    }

    public void validateTryCount(String tryCount) {
        validateIsNumber(tryCount);
        int count = parseAndValidateIntRange(tryCount);
        validateIsNaturalNumber(count);
    }

    private void validateIsNumber(String tryCount) {
        if (!tryCount.matches(TRY_COUNT_REGEX)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private int parseAndValidateIntRange(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_OUT_OF_INT_RANGE);
        }
    }

    private void validateIsNaturalNumber(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ERROR_MINUS_NUMBER);
        }
    }

    private static void validateNameFormat(String name) {
        if (!name.matches(CAR_NAME_REGEX)) {
            throw new IllegalArgumentException(ERROR_INVALID_NAME_FORMAT);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_EXCEED_NAME_LENGTH);
        }
    }
}
