package racingcar.view.domain;

import racingcar.view.global.Validator;

public class Car {
    private static int NAME_MAX_LENGTH = 5;
    private String name;

    public Car(String str) {
        Validator.validString(str);
        if (str.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = str;
    }

    public String getName() {
        return name;
    }
}
