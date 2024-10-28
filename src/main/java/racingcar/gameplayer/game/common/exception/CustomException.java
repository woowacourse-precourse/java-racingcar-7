package racingcar.gameplayer.game.common.exception;

public class CustomException extends IllegalArgumentException{

    private final ErrorMessage message;


    public CustomException(ErrorMessage message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.getMessage();
    }
}
