package racingcar.exception;

public class Validator {

    public static void checkNameLen(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
    }
}
