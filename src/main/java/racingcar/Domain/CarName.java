package racingcar.Domain;

import racingcar.Message.ErrorMessage;

public class CarName {
    private final String value;
    private static final int MAX_NAME_LENGTH = 5;

    private CarName(String value) {
        validatName(value);
        this.value = value;
    }

    public static CarName from(String value) {
        return new CarName(value);
    }

    private void validateBlank (String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_BLANK);
        }
    }
    private void validateLength (String name) {
       if (name.length() > MAX_NAME_LENGTH) {
           throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_LENGTH);
       }
    }

    private void validatName(String name) {
        validateLength(name);
        validateBlank(name);
    }

    public String getValue() {
        return value;
    }

}
