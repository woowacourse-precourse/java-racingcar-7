package racingcar.model;

import racingcar.exception.CarException;
import racingcar.strategy.Mode;
import racingcar.view.OutputView;

public class Car {
    private final String carName;
    private Mode mode;

    public Car(String carName) {
        validate(carName);
        this.carName = carName;
    }

    private void validate(String carName) {
        CarException.nameException(carName);
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

    public String getMode() {
        return mode.getClass().getSimpleName();
    }

    public void setMoveDistance(Integer move) {
        mode.setMovementDistance(move);
    }
}
