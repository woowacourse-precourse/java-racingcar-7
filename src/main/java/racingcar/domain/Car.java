package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car {

    private String carName;
    private int distance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            distance++;
        }
    }

    public String getName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }


}
