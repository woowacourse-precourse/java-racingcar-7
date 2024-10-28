package racingcar.validation;

import static racingcar.exception.ErrorMessage.*;

import java.util.List;

public class NameValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateNames(List<String> nameList) {
        for (String name : nameList) {
            if (name.equals(" ")) {
                throw new IllegalArgumentException(EMPTY_NAME.getMessage());
            }
            validateLength(name);
        }
    }

    public static void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
        }
    }
}
