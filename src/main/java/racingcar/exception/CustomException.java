package racingcar.exception;

import racingcar.message.MessageManager;

public class CustomException extends IllegalArgumentException{
    public CustomException(MessageManager messageManager){
        super(messageManager.getMessage());
    }
}
