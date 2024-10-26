package racingcar.domain;

import racingcar.exception.GameErrorMessage;

public class Input {
    private final String input;
    public Input(final String input) {
        validateEmpty(input);
        this.input = input;
    }

    private void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(GameErrorMessage.INPUT_EMPTY.getValue());
        }
    }

    public String getInput() {
        return input;
    }

}
