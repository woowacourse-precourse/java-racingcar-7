package racingcar.domain.car;


import java.util.Objects;

public class Car {
    private final CarName carName;
    private final Position currentPosition;

    public Car(String name) {
        this.carName = new CarName(name);
        this.currentPosition = new Position();
    }

    public void accelerate() {
        currentPosition.addPosition();
    }

    public boolean isAtSameOrAheadOf(Integer otherCarPosition) {
        return currentPosition.isGreaterThanOrEqualTo(otherCarPosition);
    }

    public CarInfo getCarInfo() {
        return new CarInfo(carName, currentPosition);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carName);
    }
}
