package racingcar.context;

import racingcar.strategy.MovementStrategy;

public class Car {
    private final String carName;
    private Integer carMovementDistance;
    private MovementStrategy carStrategy;

    public Car(String carName, MovementStrategy carStrategy) {
        this.carName = carName;
        this.carMovementDistance = 0;
        this.carStrategy = carStrategy;
    }

    public void moveCar() {
        if (carStrategy.move()) {
            carMovementDistance++;
        }
    }

    //결과 출력 - 자동차 이름 : -
}
