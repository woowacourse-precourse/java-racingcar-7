package racingcar.utils;

public class Validator {
    public void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_OVER_LIMIT.getMessage());
        }
    }

    public int validateCount(String count) {
        try {
           return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_NOT_NUMBER.getMessage());
        }
    }
}
