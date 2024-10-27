package racingcar.io;

public class InputValidator {

    private static final String EMPTY_INPUT_ERROR = "빈 값은 허용하지 않습니다.";
    private static final String INVALID_COUNT_ERROR = "횟수는 0보다 커야 합니다.";

    public void validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) { // 공백 문자열도 허용하지 않음
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    public void validateCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(INVALID_COUNT_ERROR);
        }
    }

}