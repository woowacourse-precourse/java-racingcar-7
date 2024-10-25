package racingcar;

import java.util.List;

public class Car {
    private List<String> carNames;

    public void setCarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public String getCarNames() {
        return String.join(", ", carNames);
    }
}

