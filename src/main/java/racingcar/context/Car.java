package racingcar.context;

import racingcar.strategy.CarStrategy;

public class Car {
    private final String carName;
    private Integer carMovementDistance;
    private CarStrategy carStrategy;

    public Car(String carName, CarStrategy carStrategy) {
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
