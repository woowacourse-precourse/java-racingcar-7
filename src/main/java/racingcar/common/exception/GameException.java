package racingcar.common.exception;

public class GameException extends IllegalArgumentException {

    private final ErrorCode errorCode;

    public GameException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}