package racingcar.domain;

public class Car {

    private static final String STATUS_CHARACTER = "-";

    private final CarName name;
    private final CarPosition position;

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        position.increase();
    }

    public boolean isPositionGreaterThan(Car otherCar) {
        return this.position.isGreaterThan(otherCar.position);
    }

    public boolean hasSamePositionAs(Car otherCar) {
        return this.position.equals(otherCar.position);
    }

    public CarName getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s : %s",
                name.getName(),
                STATUS_CHARACTER.repeat(position.getPosition()));
    }
}
