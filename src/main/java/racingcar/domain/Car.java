package racingcar.domain;

import racingcar.global.exception.CustomException;
import racingcar.global.exception.ErrorMessage;

public class Car {
    private static int NAME_MAX_LENGTH = 5;
    private String name;

    public Car(String name) {
        if (isNameEmpty(name)) {
            throw CustomException.of(ErrorMessage.BLANK_CAR_NAME_ERROR);
        }
        if (isNameTooLong(name)) {
            throw CustomException.of(ErrorMessage.CAR_NAME_TOO_LONG_ERROR);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isNameEmpty(String name) {
        return name == null || name.isBlank();
    }

    private boolean isNameTooLong(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }
}
