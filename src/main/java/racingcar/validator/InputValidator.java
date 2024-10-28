package racingcar.validator;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";
    private static final String INVALID_MOVE_COUNT_MESSAGE = "이동 횟수는 숫자만 가능합니다.";
    private static final String INVALID_MOVE_COUNT_POSITIVE_MESSAGE = "이동 횟수는 1 이상만 가능합니다.";

    public static void validateStringArray(String[] strings) {
        for (String str : strings) {
            if (isInvalidLength(str)) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
            }
        }
    }

    public static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MOVE_COUNT_MESSAGE);
        }
    }

    private static boolean isInvalidLength(String str) {
        return str.length() > MAX_NAME_LENGTH || str.isEmpty();
    }

    public static void validPositive(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(INVALID_MOVE_COUNT_POSITIVE_MESSAGE);
        }
    }
}