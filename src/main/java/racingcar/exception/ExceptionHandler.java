package racingcar.exception;

import camp.nextstep.edu.missionutils.Console;

public class ExceptionHandler {
    private ExceptionHandler(){}

    public static void handleIllegalArgumentException(ErrorMessage errorMessage) throws IllegalArgumentException{
        Console.close();
        throw new IllegalArgumentException(errorMessage.getMessage());
    }
}
