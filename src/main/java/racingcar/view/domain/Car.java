package racingcar.view.domain;

import racingcar.view.global.Validator;
import racingcar.view.global.exception.CustomException;
import racingcar.view.global.exception.ErrorMessage;

public class Car {
    private static int NAME_MAX_LENGTH = 5;
    private String name;

    public Car(String name) {
        Validator.validString(name);
        if (isNameTooLong(name)) {
            throw CustomException.of(ErrorMessage.CAR_NAME_TOO_LONG_ERROR);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isNameTooLong(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }
}
