package racingcar.exception;

import racingcar.message.ErrorMessage;

public class CustomException extends IllegalArgumentException{
    public CustomException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
    }
}
