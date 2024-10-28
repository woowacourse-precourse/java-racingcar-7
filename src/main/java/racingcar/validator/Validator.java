package racingcar.validator;

import java.util.List;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";
    private static final String INVALID_MOVE_COUNT_MESSAGE = "이동 횟수는 숫자만 가능합니다.";
    private static final String INVALID_MOVE_COUNT_POSITIVE_MESSAGE = "이동 횟수는 1 이상만 가능합니다.";
    private static final String INVALID_NAME_CONTAINS_SPACE_MESSAGE = "자동차 이름에는 공백이 포함될 수 없습니다.";
    private static final String INVALID_NAME_DUPLICATE_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private static final String INVALID_COMMA_FORMAT_MESSAGE = "이름 목록은 쉼표로 시작하거나 끝나거나 연속된 쉼표를 포함할 수 없습니다.";

    public static void checkBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(INVALID_NAME_CONTAINS_SPACE_MESSAGE);
        }
    }

    public static void checkDuplicateCarNames(List<String> splitCarNames) {
        if (splitCarNames.size() != splitCarNames.stream().distinct().count()) {
            throw new IllegalArgumentException(INVALID_NAME_DUPLICATE_MESSAGE);
        }
    }

    public static void checkCommaFormat(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(INVALID_COMMA_FORMAT_MESSAGE);
        }
    }

    public static void checkNameLength(List<String> names) {
        for (String name : names) {
            if (isInvalidLength(name)) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
            }
        }
    }

    public static int parseMoveCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MOVE_COUNT_MESSAGE);
        }
    }

    private static boolean isInvalidLength(String str) {
        return str.length() > MAX_NAME_LENGTH || str.isEmpty();
    }

    public static void checkPositiveMoveCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(INVALID_MOVE_COUNT_POSITIVE_MESSAGE);
        }
    }
}