package racingcar.exception;

import camp.nextstep.edu.missionutils.Console;

public class RacingException extends IllegalArgumentException {

    private RacingException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RacingException of(ErrorMessage errorMessage) {
        Console.close();
        return new RacingException(errorMessage);
    }
}
