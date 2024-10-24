package racingcar.exception;

public class GameException extends IllegalArgumentException {
    GameException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
