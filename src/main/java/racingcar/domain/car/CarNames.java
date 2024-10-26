package racingcar.domain.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNames {
    private final List<String> carNames;

    public CarNames(List<String> carNames) {
        validateDuplicatedCarName(carNames);
        this.carNames = carNames;
    }

    private static void validateDuplicatedCarName(List<String> carNames) {
        Set<String> cars = new HashSet<>(carNames);
        if (cars.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
