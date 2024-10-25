package racingcar.domain;

import java.util.Objects;
import racingcar.common.exception.CarPositionOutOfRangeException;

public class Car {

    private static final int CAR_POSITION_INIT = 0;
    private static final int CAR_POSITION_MAX_CRITERIA = Integer.MAX_VALUE-2;

    private final String carName;
    private int carPosition;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = CAR_POSITION_INIT;
    }

    public void forward() {
        if(carPosition > CAR_POSITION_MAX_CRITERIA) {
            throw new CarPositionOutOfRangeException(carName, carPosition);
        }
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
