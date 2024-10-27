package racingcar.view.domain;

import racingcar.view.global.Validator;

public class Car {
    private String name;
    public Car(String str) {
        Validator.validString(str);
        this.name = str;
    }
}
