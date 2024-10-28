package racingcar.domain.car;

import racingcar.domain.strategy.MoveStrategy;

public class Car {
    private String carName;
    private int currentDistance;
    private MoveStrategy moveStrategy;

    public Car(String carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.moveStrategy = moveStrategy;
        currentDistance = 0;
    }

    public int move(){
        if(moveStrategy.isAllowedToAdvance())
            currentDistance++;
        return currentDistance;
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentDistance() {
        return currentDistance;
    }
}
