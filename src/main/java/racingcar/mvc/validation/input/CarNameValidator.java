package racingcar.mvc.validation.input;

import java.util.ArrayList;
import java.util.List;

public class CarNameValidator {
    public static final String NAME_DELIMITER = ",";
    private static final int VALID_INPUT_LENGTH = 5;
    private static final String NAME_REGEX = "^[\\w가-힣-.]+$";
    private static final String WHITESPACE = " ";

    public static void isValid(String input) {
        isEmpty(input);

        List<String> names = new ArrayList<>();

        for (String name : input.split(NAME_DELIMITER, -1)) {
            name = name.trim();

            isEmpty(name);

            isValidLength(name);

            containWhiteSpace(name);

            containOnlyAllowedSpecialCharacters(name);

            isDuplicated(names, name);
        }
    }

    private static void isEmpty(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력하지 않았습니다.");
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static void isValidLength(String input) {
        if (compareWithCriterion(input)) {
            throw new IllegalArgumentException("이름은 " + VALID_INPUT_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    private static boolean compareWithCriterion(String input) {
        return input.length() > VALID_INPUT_LENGTH;
    }

    private static void containWhiteSpace(String input) {
        if (input.contains(WHITESPACE)) {
            throw new IllegalArgumentException("이름은 공백을 가질 수 없습니다.");
        }
    }

    private static void containOnlyAllowedSpecialCharacters(String input) {
        if (!input.matches(NAME_REGEX)) {
            throw new IllegalArgumentException(input + "에 허용되지 않은 특수문자가 포함되어 있습니다.");
        }
    }

    private static void isDuplicated(List<String> names, String input) {
        if (names.contains(input)) {
            throw new IllegalArgumentException(input + "은 이미 사용된 이름입니다.");
        }
    }
}
