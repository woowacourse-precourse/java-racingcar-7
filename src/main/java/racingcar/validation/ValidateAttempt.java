package racingcar.validation;

import racingcar.exception.Exception;

public class ValidateAttempt {

    public static void isInteger(String inputAttempt) {
        try {
            Integer.parseInt(inputAttempt);
        } catch(IllegalArgumentException e) {
            Exception.exceptionAttemptInteger();
        }
    }

    public static void isOverZero(int attempt) {
        if(attempt < 1) Exception.exceptionAttemptZero();
    }

}
