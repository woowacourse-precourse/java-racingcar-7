package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompeteCars {
    private static final String ERROR_CAR_NAME_DUPLICATION = "자동차 이름은 중복될 수 없습니다.";
    private final List<Car> cars = new ArrayList<>();

    private void validateDuplicatedCar() {
        Set<Car> uniqueCars = new HashSet<>(cars);
        if (uniqueCars.size() < cars.size()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_DUPLICATION);
        }
    }

    public CompeteCars(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        validateDuplicatedCar();
    }

    public List<Car> getAll() {
        return cars;
    }
}
