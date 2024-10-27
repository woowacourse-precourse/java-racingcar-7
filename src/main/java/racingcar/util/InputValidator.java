package racingcar.util;

public class InputValidator {
    public static void validCarName(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }
}
