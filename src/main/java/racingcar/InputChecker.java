package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputChecker {
    private static final int MAX_NAME_LENGTH = 5;

    public static void runException(String names, String attempts) {
        InputChecker checker = new InputChecker();
        checker.checkAndParseCarNames(names);
        checker.checkAndParseCarNames(attempts);
    }

    public List<String> checkAndParseCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }

        List<String> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        checkCarNames(names);
        return names;
    }

    private void checkCarNames(List<String> names) {
        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public int checkAndParseAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }
}