package racingcar.global.util;

import racingcar.global.enums.ErrorMessage;

public class Validator {
    private static Validator instance;

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NOT_ALLOWED_EMPTY_SPACE.getMessage());
        }
    }

    public Integer validateAndReturnCount(String count) {
        if (count.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_EMPTY_SPACE.getMessage());
        }

        try {
            return Integer.parseInt(count);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.getMessage());
        }
    }

    public Integer isPositiveNumber(Integer count) {
        if (count > 0) {
            return count;
        }
        throw new IllegalArgumentException(ErrorMessage.ALLOWED_ONLY_POSITIVE.getMessage());
    }
}
