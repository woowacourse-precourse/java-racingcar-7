package racingcar.utils;

import racingcar.message.ErrorMessage;

public class ExceptionUtils {

    public static void throwException(ErrorMessage error) throws IllegalArgumentException {
        String message = error.getMessage();
        System.out.println(message);
        throw new IllegalArgumentException(message);
    }
}
