package racingcar.domain;

import java.util.HashSet;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars makeCars(List<String> carNames) {
        checkCarNameDuplicate(carNames);
        carNames.forEach(carName -> cars.add(new Car(carName)));
        return this;
    }

    private void checkCarNameDuplicate(List<String> carNames) {
        HashSet<Object> set = new HashSet<>();
        carNames.forEach(carName -> {
            if (!set.add(carName)) {
                throw new IllegalArgumentException("자동차 이름 ${carName}이 중복되었습니다.");
            }
        });
    }
}
