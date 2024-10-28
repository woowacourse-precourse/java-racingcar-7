package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorMessage;
import racingcar.exception.ExceptionHandler;

public class InputView {
    public String getLine(){
        String input = Console.readLine();
        if(input.isEmpty()){
            ExceptionHandler.handleIllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
        return input;
    }
}
