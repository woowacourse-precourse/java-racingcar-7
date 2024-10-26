package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CompeteCars {
    private final List<Car> cars = new ArrayList<>();

    private void validateDuplicatedCar(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public CompeteCars(String Input) {
        for (String carName : Input.split(",")) {
            Car car = new Car(carName);
            validateDuplicatedCar(car);
            cars.add(car);
        }
    }

    public List<Car> getAll() {
        return cars;
    }
}
