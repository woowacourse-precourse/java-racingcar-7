package racingcar.domain.car;


import java.util.Objects;

public class Car {
    private final CarName carName;
    private final CarPosition currentCarPosition;

    public Car(String name) {
        this.carName = new CarName(name);
        this.currentCarPosition = new CarPosition();
    }

    public void accelerate() {
        currentCarPosition.addPosition();
    }

    public CarInfo getCarInfo() {
        return new CarInfo(carName, currentCarPosition);
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
