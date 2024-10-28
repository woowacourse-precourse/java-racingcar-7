package racingcar;

import java.util.List;

// 추후 유틸성 class 로 전환?
public class CarConverter {

    public List<Car> toCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<String> toNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

}
