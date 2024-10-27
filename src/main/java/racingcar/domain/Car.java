package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final String INPUT_LENGTH_EXCEEDED_ERROR = "5자 초과하였습니다.";
    private static final String EMPTY_NAME_ERROR = "이름이 없습니다.";
    private static final int FOWARD_NUMBER = 4;
    private final String carName;
    private Distance distance;

    public Car(String carName) {
        this(carName, new Distance(0));
    }

    public Car(String carName, Distance distance) {
        validateCarName(carName);
        this.carName = carName;
        this.distance = distance;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEEDED_ERROR);
        } else if (carName.length() == 0) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    public String getCarName() {
        return carName;
    }

    public Distance getDistance() {
        return distance;
    }

    public int getDistanceValue() {
        return distance.getDistanceValue();
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= FOWARD_NUMBER) {
            this.distance = distance.increaseDistance();
        }
    }

    public int max(int maxDistance) {
        return distance.max(maxDistance);
    }

    public boolean isSameDistance(int distanceValue) {
        return distance.isSameDistance(distanceValue);
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
