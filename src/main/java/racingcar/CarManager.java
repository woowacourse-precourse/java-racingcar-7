package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarManager {

    private final List<Car> cars;

    // 자동차 이름을 받아서 생성하는 로직으로 수정 필요
    public CarManager(final String[] carNames) {
        validateDuplicateCarName(carNames);
        this.cars = initializeCars(carNames);
    }

    private void validateDuplicateCarName(final String[] carNames) {
        Set<String> existingCarNames = new HashSet<>();
        for (String carName : carNames) {
            if (!existingCarNames.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
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
