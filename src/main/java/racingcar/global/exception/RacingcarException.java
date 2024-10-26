package racingcar.global.exception;


import racingcar.global.globalEnum.Message;

public class RacingcarException extends IllegalArgumentException {
    public RacingcarException(Message errorMessage) {
        super(errorMessage.getMessage());
    }
}