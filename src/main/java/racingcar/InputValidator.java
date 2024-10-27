package racingcar;

import java.util.List;

public class InputValidator {

    public Boolean isValidInputFormat(String input) {
        if (input.startsWith(RegexPatterns.DELIMITER) || input.endsWith(RegexPatterns.DELIMITER)) {
            throw new IllegalArgumentException("구분자를 이름에 포함할 수 없습니다.");
        }
        return true;
    }

    public Boolean isValidName(String input) {
        List<String> names = Parser.splitByDelimiter(input);
        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("구분자를 이름에 포함할 수 없습니다.");
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
        return true;
    }

    public Boolean isValidRound(String input) {
        if (!input.matches(RegexPatterns.DIGIT_REGEX)) {
            throw new IllegalArgumentException("시도횟수로 숫자만 입력 가능합니다.");
        }
        return true;
    }
}
