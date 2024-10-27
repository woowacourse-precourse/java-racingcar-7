package racingcar.domain.car;


import java.util.Objects;

public class Car {
    private final CarName carName;
    private final CarPosition currentCarPosition;

    public Car(String carName) {
        this.carName = new CarName(carName);
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
        return this == object || (object instanceof Car && Objects.equals(carName, ((Car) object).carName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

}
