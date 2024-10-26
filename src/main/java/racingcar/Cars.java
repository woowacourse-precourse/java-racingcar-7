package racingcar;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public void validate(List<Car> cars) {
        validateCarCount(cars);
        validateDuplication(cars);
    }

    private void validateDuplication(List<Car> cars) {
        Set<String> duplicatedNames = new HashSet<>();
        for (Car car : cars) {
            duplicatedNames.add(car.getName());
        }
        if (duplicatedNames.size() != cars.size()) {
            throw new IllegalArgumentException("이름은 중복이 불가합니다.");
        }
    }
}
