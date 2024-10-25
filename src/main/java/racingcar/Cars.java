package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;


    public Cars(List<String> names) {
        validateDuplicateNames(names);
        this.cars = createCars(names);
    }

    private void validateDuplicateNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

}
