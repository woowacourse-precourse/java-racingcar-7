package racingcar.context;

import racingcar.strategy.CarStrategy;
import racingcar.validation.CarNameValidation;
import racingcar.view.OutputView;

public class RacingCar {
    private final String carName;
    private Integer carMovementDistance;
    private CarStrategy carStrategy;

    public RacingCar(String carName, CarStrategy carStrategy) {
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
        OutputView.printCarRacingProcess(carName, carMovementDistance);
    }

    public String getCarName() {
        return carName;
    }

    public Integer getCarMovementDistance() {
        return carMovementDistance;
    }
}
