package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CompeteCars {
    private static final String ERROR_CAR_NAME_DUPLICATION = "자동차 이름은 중복될 수 없습니다.";
    private final List<Car> cars = new ArrayList<>();

    private void validateDuplicatedCar(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_DUPLICATION);
        }
    }

    public CompeteCars(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            validateDuplicatedCar(car);
            cars.add(car);
        }
    }

    public List<Car> getAll() {
        return cars;
    }
}
