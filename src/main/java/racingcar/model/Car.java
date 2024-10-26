package racingcar.model;

import racingcar.exception.CarNameLengthException;
import racingcar.strategy.Mode;
import racingcar.validation.CarNameValidation;
import racingcar.view.OutputView;

public class Car {
    private final String carName;
    private Mode mode;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (CarNameValidation.validateCarNameLength(carName)) {
            throw new CarNameLengthException();
        }
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
