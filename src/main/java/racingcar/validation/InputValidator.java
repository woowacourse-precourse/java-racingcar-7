package racingcar.validation;

public class InputValidator {

    public static void validateCarNames(String input) {
        if (!input.matches("^[a-zA-Z0-9]{1,5}(,[a-zA-Z0-9]{1,5})*$")) {
            throw new IllegalArgumentException("입력이 잘못되었습니다. 쉼표로 구분된 1~5글자의 알파벳 또는 숫자만 입력 가능합니다.");
        }
    }

    public static void validateAttemptCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
