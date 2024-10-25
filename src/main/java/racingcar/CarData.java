package racingcar;

import java.util.List;

public class CarData {
    private List<String> carNames;

    private int movementNumber;

    public void setCarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public String getCarNames() {
        return String.join(", ", carNames);
    }

    public int getMovementNumber() {
        return movementNumber;
    }

    public void setMovementNumber(int movementNumber) {
        this.movementNumber = movementNumber;
    }
}

