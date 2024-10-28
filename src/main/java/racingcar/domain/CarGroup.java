package racingcar.domain;

import java.util.List;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }
}
