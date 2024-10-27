package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    private final List<CarName> carNames;

    private CarNames(final List<CarName> carNames) {
        this.carNames = carNames;
    }

    List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public static CarNames of(final List<String> inputCarNames) {
        return new CarNames(inputCarNames.stream()
                .map(inputCarName -> inputCarName.trim())
                .map(inputCarName -> CarName.of(inputCarName))
                .collect(Collectors.toList()));
    }
}
