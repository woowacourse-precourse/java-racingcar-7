package racingcar.domain.car;

import static racingcar.error.ErrorMessageConstants.CAR_NAME_TOO_LONG;
import static racingcar.error.ErrorMessageConstants.INVALID_CAR_NAME;

import racingcar.domain.car.strategy.MovingStrategy;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private Integer position = 0;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        validateCarName(carName);
        this.name = carName;
        this.movingStrategy = movingStrategy;
    }

    private void validateCarName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG);
        }
    }

    public void oneRoundStart() {
        move();
    }

    private void move() {
        if (movingStrategy.canMove()) {
            this.position++;
        }
    }

    public boolean isAheadOf(Car otherCar) {
        return this.position > otherCar.position;
    }

    public boolean isSamePositionAs(Car leadingCar) {
        return this.position.equals(leadingCar.position);
    }


    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}