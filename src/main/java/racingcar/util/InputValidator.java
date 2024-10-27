package racingcar.util;

import java.util.List;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateCarNames(final List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 리스트는 비어있을 수 없습니다.");
        }

        carNames.forEach(InputValidator::validateCarName);
    }

    private static void validateCarName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }

        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_CAR_NAME_LENGTH + "글자를 초과할 수 없습니다: " + name);
        }
    }

    public static int validateAndParseAttempts(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("이동 횟수 입력은 비어있을 수 없습니다.");
        }

        try {
            int attempts = Integer.parseInt(input);
            validateAttempts(attempts);
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.", e);
        }
    }

    private static void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
    }
}
