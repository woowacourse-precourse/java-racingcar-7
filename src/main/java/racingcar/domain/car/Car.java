package racingcar.domain.car;

import racingcar.domain.car.strategy.MovingStrategy;
import racingcar.validator.CarValidator;

public class Car {

    private final String name;
    private Integer position = 0;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        CarValidator.validateCarName(carName);
        this.name = carName;
        this.movingStrategy = movingStrategy;
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