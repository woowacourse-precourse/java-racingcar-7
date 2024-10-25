package racingcar.model;

public class Car {
    private final CarName carName;
    private final Position position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = new Position();
    }

    public void forwardDistance() {
        position.moveForward();
    }

    @Override
    public String toString() {
        return getName() + " : " + "-".repeat(getDistance());
    }

    public Integer getDistance() {
        return position.getPosition();
    }

    public String getName() {
        return carName.getName();
    }
}
