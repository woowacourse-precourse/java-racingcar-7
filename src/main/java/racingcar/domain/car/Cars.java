package racingcar.domain.car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(CarNames carNames) {
        List<Car> cars = new ArrayList<>();
        List<String> names = carNames.getCarNames();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        validateDuplicatedName(names);
        return new Cars(cars);
    }

    private static void validateDuplicatedName(List<String> names) {
        Set<String> cars = new HashSet<>(names);
        if (cars.size() != names.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
