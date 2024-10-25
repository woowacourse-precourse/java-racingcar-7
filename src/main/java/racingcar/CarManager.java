package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarManager {

    private final List<Car> cars;

    // 자동차 이름을 받아서 생성하는 로직으로 수정 필요
    public CarManager(final String[] carNames) {
        CarValidator.validateDuplicateCarName(carNames);
        this.cars = initializeCars(carNames);
    }

    private List<Car> initializeCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
