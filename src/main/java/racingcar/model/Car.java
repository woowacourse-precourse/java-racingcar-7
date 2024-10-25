package racingcar.model;

import racingcar.strategy.Mode;
import racingcar.validation.CarNameValidation;
import racingcar.view.OutputView;

public class Car {
    private final String carName;
    private Mode mode;

    public Car(String carName) {
        if (CarNameValidation.validateCarNameLength(carName)) {
            throw new IllegalArgumentException("자동차 이름 예외");
        }
        this.carName = removeCarNameSpace(carName);
    }

    private String removeCarNameSpace(String carName) {
        return carName.trim();
    }

    public void tryMoving() {
        if (mode != null) {
            mode.go();
            OutputView.printCarRacingProcess(carName, mode.getMovementDistance());
        }
    }

    public void setMode(Mode move) {
        this.mode = move;
    }

    public Integer getMoveDistance() {
        return mode.getMovementDistance();
    }

    public String getCarName() {
        return carName;
    }
}
