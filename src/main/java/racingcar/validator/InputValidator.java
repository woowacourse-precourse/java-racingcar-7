package racingcar.validator;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String charRegex = "^[ㄱ-ㅎ|가-힣|a-z|A-Z]*$";
    private static final String numRegex = "^[0-9]*$";

    // 자동차의 이름은 문자(영어 or 한글)로만 이루어져 있다고 가정
    public static void isStringOnly(String input) {
        if (!Pattern.matches(charRegex, input) || input.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void isNumberOnly(String input) {
        if (!Pattern.matches(numRegex, input)) {
            throw new IllegalArgumentException();
        }
    }
}
