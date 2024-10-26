package racingcar.domain;

import java.util.List;

public class CarFactory {

    public List<Car> getCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

}
