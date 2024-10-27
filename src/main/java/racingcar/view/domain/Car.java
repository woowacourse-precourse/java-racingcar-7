package racingcar.view.domain;

import racingcar.view.global.Validator;

public class Car {
    private static int NAME_MAX_LENGTH = 5;
    private String name;

    public Car(String name) {
        Validator.validString(name);
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
