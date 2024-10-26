package racingcar;

public class Validator {
    private static final String ERROR_MESSAGE_INPUT_EMPTY = "자동차 이름을 입력해주세요.";

    public void inputSting(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_EMPTY);
        }
    }

}
