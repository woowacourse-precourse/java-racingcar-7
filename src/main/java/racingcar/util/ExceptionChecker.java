package racingcar;

import java.util.List;

public class ExceptionChecker {
    static String regexNameInput = "[^a-zA-Z0-9가-힣,\\s]";
    static String regexRoundInput = "[^1-9]";

    public static void validateNameInput(String input) {
        validateAnotherDelimiterInput(input);
        validateIsEmptyInput(input);
    }

    public static void validateRoundInput(String input) {
        validateIsEmptyInput(input);
        validateIsEmptyRounds(input);
    }


    public static void validateAnotherDelimiterInput(String input) {
        if (input.matches(".*" + regexNameInput + ".*")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static void validateIsLengthOver(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
            }
        }
    }

    public static void validateIsEmptyRounds(String input) {
        if (input.matches(regexRoundInput)) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요.");
        }
    }

    public static void validateIsEmptyInput(String input) {
        if (input.isBlank() | input == null) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }
    }
}
