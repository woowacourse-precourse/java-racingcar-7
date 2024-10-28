package racingcar.util.validator;

import racingcar.util.Util;

public class InputCommaValidator {
    private InputCommaValidator() {  // 인스턴스화 방지
    }

    public static void validateFormat(String input) {
        String trimmed = Util.removeSpace(input);
        if (trimmed.endsWith(",") ||
                trimmed.startsWith(",") ||
                trimmed.contains(",,")) {
            throw new IllegalArgumentException();
        }
    }
}