package racingcar.Domain;

import racingcar.Message.ErrorMessage;

public class MoveCount {
    private int value;

    public MoveCount(String input) {
        this.value = parseInt(input);
        validate();
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private void validate() {
        if (value < 1) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INVALID_MOVE_COUNT);
        }
    }

    public int getValue() {
        return value;
    }
}
