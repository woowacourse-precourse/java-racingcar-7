package racingcar.model;

import racingcar.utils.Validator;

public class Car {
    private final String name;
    private int distance;

    private Car(String name) {
        validate(name);
        this.name = name;
        this.distance = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void move(MovementStrategy movingStrategy) {
        if (movingStrategy.moveable()) {
            distance++;
        }
    }

    private void validate(String name) {
        Validator.isEmpty(name);
        Validator.isCarNameRange(name);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

}
