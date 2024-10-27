package racingcar;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public void validateCarNames(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }

        String[] names = input.split(",");
        for (String name : names) {
            validateCarName(name);
        }
    }

    private void validateCarName(String name) {
        if (name.isEmpty() || name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이거나 공백을 포함할 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void validateAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
