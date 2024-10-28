package racingcar.Domain;

import racingcar.Validator.CarNameValidator;

public class Car {
    private final CarName name;
    private final Position position;

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = CarName.from(name);
        this.position = new Position();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void move() {
        if (MovingStrategy.canMove()) {
            position.moveForward();
        }
    }

    public String getName() {
        return name.getValue();
    }
}
