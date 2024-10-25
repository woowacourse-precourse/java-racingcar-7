package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int CAR_INIT_POSITION = 0;

    private final String carName;
    private int carPosition;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = CAR_INIT_POSITION;
    }

    public void forward() {
        this.carPosition++;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
