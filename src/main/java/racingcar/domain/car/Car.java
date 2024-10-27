package racingcar.domain.car;

import java.util.Objects;
import racingcar.common.exception.CarPositionOutOfRangeException;
import racingcar.common.exception.IllegalCarNameException;

public class Car {

    private static final int CAR_POSITION_INIT = 0;
    private static final int CAR_POSITION_MAX_CRITERIA = Integer.MAX_VALUE - 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String carName;
    private int carPosition;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.carPosition = CAR_POSITION_INIT;
    }

    public void forward() {
        validateCarPositionToForward();
        this.carPosition++;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    private void validateCarName(String carName) {
        if(carName == null || carName.isBlank()) {
            throw new IllegalCarNameException(carName);
        }
        if(carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalCarNameException(carName, carName.length());
        }
    }

    private void validateCarPositionToForward() {
        if (carPosition > CAR_POSITION_MAX_CRITERIA) {
            throw new CarPositionOutOfRangeException(carName, carPosition);
        }
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
