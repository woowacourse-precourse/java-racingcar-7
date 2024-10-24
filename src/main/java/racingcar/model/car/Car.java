package racingcar.model.car;

import racingcar.model.number.Number;

public class Car {
    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void goOrStop(final Number number) {
        if (number.isGreaterThanForwardThreshold()) {
            position.increasePosition();
        }
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
