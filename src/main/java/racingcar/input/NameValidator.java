package racingcar.input;

import java.util.List;
import racingcar.error.ErrorCode;

public class NameValidator {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public static void validate(List<String> names) {
        for (String name : names) {
            validate(name);
        }
    }

    public static void validate(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    ErrorCode.INVALID_CAR_NAME.getMessage(MIN_NAME_LENGTH, MAX_NAME_LENGTH)
            );
        }
    }
}
