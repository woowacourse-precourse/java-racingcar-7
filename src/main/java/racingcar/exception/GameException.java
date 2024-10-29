package racingcar.exception;

public class GameException extends IllegalArgumentException {
    public GameException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
