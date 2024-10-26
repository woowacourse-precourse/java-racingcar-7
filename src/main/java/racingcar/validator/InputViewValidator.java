package racingcar.validator;

public class InputViewValidator {
    private static final String EMPTY_OR_BLANK_INPUT_ERROR = "입력이 비어있거나 공백일 수 없습니다.";

    public void validateNotEmptyAndBlank(String input) {
        if (input.isEmpty() || input.trim().isBlank()) {
            throw new IllegalArgumentException(EMPTY_OR_BLANK_INPUT_ERROR);
        }
    }
}
