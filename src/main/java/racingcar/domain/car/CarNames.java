package racingcar.domain.car;

import java.util.List;

public class CarNames {
    private final List<String> carNames;

    public CarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
