package racingcar.context;

import racingcar.strategy.CarStrategy;
import racingcar.validation.CarNameValidation;

public class Car {
    private final String carName;
    private Integer carMovementDistance;
    private CarStrategy carStrategy;

    public Car(String carName, CarStrategy carStrategy) {
        if (CarNameValidation.validateCarNameLength(carName)) {
            throw new IllegalArgumentException("자동차 이름 예외");
        }
        this.carName = carName;
        this.carMovementDistance = 0;
        this.carStrategy = carStrategy;
    }

    public void moveCar() {
        if (carStrategy.move()) {
            carMovementDistance++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public Integer getCarMovementDistance() {
        return carMovementDistance;
    }

    //결과 출력 - 자동차 이름 : -
}
