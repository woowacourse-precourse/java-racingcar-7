package racingcar.exception;

import racingcar.exception.game.GameException;

public class InputException extends GameException {
    public InputException(String message) {
        super(message);
    }

    public static class InvalidNameFormatException extends InputException {
        public InvalidNameFormatException() {
            super("올바른 이름 형식이 아닙니다.");
        }
    }

    public static class InvalidRoundInputException extends InputException {
        public InvalidRoundInputException() {
            super("라운드 수는 숫자여야 합니다.");
        }
    }
}