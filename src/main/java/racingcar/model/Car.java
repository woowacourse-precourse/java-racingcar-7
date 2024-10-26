package racingcar.model;

import racingcar.strategy.Mode;
import racingcar.validation.CarNameValidation;
import racingcar.view.OutputView;

public class Car {
    private final String carName;
    private Mode mode;

    public Car(String carName) {
        carName = removeCarNameSpace(carName);
        if (CarNameValidation.validateCarNameEmpty(carName)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 존재하지 않습니다.")
        }
        if (CarNameValidation.validateCarNameLength(carName)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
        this.carName = carName;
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
