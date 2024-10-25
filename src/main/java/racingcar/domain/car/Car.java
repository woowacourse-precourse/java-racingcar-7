package racingcar.domain.car;

public class Car implements Comparable<Car> {
    private static final int MOVE_FORWARD_UNIT = 1;
    private static final CarPosition DEFAULT_POSITION = CarPosition.of(0);
    private final CarName name;
    private final CarPosition carPosition;

    public Car(CarName carName) {
        this(carName, DEFAULT_POSITION);
    }

    public Car(CarName carName, CarPosition carPosition) {
        this.name = carName;
        this.carPosition = carPosition;
    }

    public Car moveForward() {
        CarPosition after = CarPosition.of(carPosition.getPosition() + MOVE_FORWARD_UNIT);
        return new Car(this.name, after);
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }

    @Override
    public int compareTo(Car another) {
        return Integer.compare(this.carPosition.getPosition(), another.carPosition.getPosition());
    }
}
