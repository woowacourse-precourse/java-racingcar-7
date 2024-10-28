package racingcar.exception;

import static racingcar.exception.message.InputExceptionMessages.INVALID_NAME_FORMAT;
import static racingcar.exception.message.InputExceptionMessages.ROUND_MUST_NUMBER;

import racingcar.exception.game.GameException;

public class InputException extends GameException {
    public InputException(String message) {
        super(message);
    }

    public static class InvalidNameFormatException extends InputException {
        public InvalidNameFormatException() {
            super(INVALID_NAME_FORMAT);
        }
    }

    public static class InvalidRoundInputException extends InputException {
        public InvalidRoundInputException() {
            super(ROUND_MUST_NUMBER);
        }
    }
}