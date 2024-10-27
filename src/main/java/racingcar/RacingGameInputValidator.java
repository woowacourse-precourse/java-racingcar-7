package racingcar;

import java.util.List;
import java.util.Arrays;

public class RacingGameInputValidator {
    private static final String DELIMITER = ",";
    private static final String EMPTY_INPUT_ERROR = "자동차 이름을 입력해주세요.";
    private static final String EMPTY_NAME_ERROR = "빈 이름이 포함되어 있습니다.";

    public static List<String> parseCarNames(String input) {
        validateInput(input);
        List<String> names = Arrays.asList(input.split(DELIMITER));
        validateNames(names);
        return names;
    }

    private static void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    private static void validateNames(List<String> names) {
        if (names.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }
}