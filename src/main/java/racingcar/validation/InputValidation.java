package racingcar.validation;

public class InputValidation {

    public static final String EMPTY_INPUT_ERROR = "입력은 공백이 될 수 없습니다.";
    public static final String INVALID_NUMBER_ERROR = "숫자를 입력해 주세요.";
    public static final String INVALID_POSITIVE_NUMBER_ERROR = "게임 횟수는 양수를 입력해 주세요.";

    public static void validateNotEmpty(String input, String errorMessage) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static int parsePositiveInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                throw new IllegalArgumentException(INVALID_POSITIVE_NUMBER_ERROR);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR);
        }
    }
}
