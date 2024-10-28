package racingcar.model;

import racingcar.validator.CarValidator;

public class Car {
    private final String name;

    private int position;

    public Car(String name) {
        CarValidator.validateName(name);

        this.name = name;
        this.position = 0;
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public void moveForward() {
        position++;
    }
}
