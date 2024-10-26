package racingcar.utils;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String NUMBER_REGEX = "^[1-9][0-9]*$";

    public static void validateRoundCount(String roundCountInput) {
        if (!Pattern.matches(NUMBER_REGEX, roundCountInput)) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수만 입력할 수 있습니다.");
        }
    }


    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }
}
