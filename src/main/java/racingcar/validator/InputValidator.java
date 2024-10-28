package racingcar.validator;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
    public static void validateMaxLength5(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("이름은 다섯 글자를 초과할 수 없습니다 : " + input);
        }
    }

    public static int parsePositiveNumberWithValidation(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < 0) {
                throw new IllegalArgumentException("양수 값이 아닙니다 : " + input);
            }
            return num;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값이 아닙니다 : " + input);
        }
    }

    public static void validateEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 공백입니다.");
        }
    }

    public static void validateAlphaNumeric(String str) {
        if (!str.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("숫자와 알파벳 외에 다른 값이 입력되었어요 : " + str);
        }
    }

    public static void validateForDuplicates(List<String> strings) {
        HashSet<String> uniqueStrings = new HashSet<>();
        for (String str : strings) {
            if (!uniqueStrings.add(str.trim())) {
                throw new IllegalArgumentException("중복된 이름입니다 : " + str.trim());
            }
        }
    }

    public static void validateEndIsAlphbetorNumber(String input) {
        char lastChar = input.charAt(input.length() - 1);
        if (!Character.isLetterOrDigit(lastChar)) {
            throw new IllegalArgumentException("입력값의 마지막 문자는 알파벳 또는 숫자여야 합니다 : " + input);
        }
    }
}