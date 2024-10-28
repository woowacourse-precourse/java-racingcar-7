package racingcar.model;

import racingcar.validation.CarNameValidator;

public class Car {
    private final String name;
    private int distance = 0;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = CarNameValidator.validate(name);
    }

    public void move() {
        if (RandomNumberGenerator.generate() >= MOVE_THRESHOLD) {
            this.distance++;
        }
    }
}
