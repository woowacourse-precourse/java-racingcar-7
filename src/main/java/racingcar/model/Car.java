package racingcar.model;

import racingcar.util.CarNameValidator;

public class Car {

    private final String carName;
    private int moveCount = 0;

    public Car(String carName, Integer moveCount) {

        CarNameValidator.validate(carName);
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public Car(String carName) {

        CarNameValidator.validate(carName);
        this.carName = carName;
    }

    public void addMoveCount() {
        moveCount++;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }


}
