package racingcar.valid;

import racingcar.constants.GameConstatns;
import racingcar.exception.ExceptionMessage;

public class NumberValid {
    public static void checkNumberType(String number){
        if(!number.matches(GameConstatns.NUMBER_REGEX)){
            throw new IllegalArgumentException(ExceptionMessage.ATTEMPT_COUNT);
        }
    }

    public static void checkNumber(int number){
        if(number < GameConstatns.ATTEMPT_COUNT_MIN){
            throw new IllegalArgumentException(ExceptionMessage.ATTEMPT_COUNT_UNDER);
        }
        if(number > GameConstatns.ATTEMPT_COUNT_MAX){
            throw new IllegalArgumentException(ExceptionMessage.ATTEMPT_COUNT_OVER);
        }
    }
}
