package racingcar.validator;

public class RoundCountValidator {

    public void validate(String input) {
        ValidationUtils.checkIfNotEmpty(input);
        checkIfNumeric(input);
        int rounds = Integer.parseInt(input);
        checkValidRange(rounds);
    }

    private void checkIfNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void checkValidRange(int rounds) {
        if (rounds < 1 || rounds > 9) {
            throw new IllegalArgumentException("시도 횟수는 1에서 9 사이의 값이어야 합니다.");
        }
    }

}
