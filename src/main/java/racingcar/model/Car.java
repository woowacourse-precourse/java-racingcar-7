package racingcar.model;

public class Car {
    private final CarName carName;
    private Integer position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void forwardDistance() {
        position++;
    }

    @Override
    public String toString() {
        return getName() + " : " + "-".repeat(getDistance());
    }

    public Integer getDistance() {
        return position;
    }

    public String getName() {
        return carName.getName();
    }
}
