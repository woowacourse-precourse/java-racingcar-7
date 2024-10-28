package racingcar.validator;

public class RaceValidator {
    private RaceValidator() {}

    public static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }

    public static void validateRoundsInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수를 입력해야 합니다.");
        }
        try {
            int rounds = Integer.parseInt(input);
            validateRounds(rounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }
}
