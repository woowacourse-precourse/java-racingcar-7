package racingcar.domain;

import racingcar.util.InputValidator;

public class Car {
    private String name;
    private String movement;

    public Car(String name, String movement) {
        InputValidator.validCarName(name);
        this.name = name;
        this.movement = movement;
    }
}
