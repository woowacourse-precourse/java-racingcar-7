package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateUniqueNames(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateUniqueNames(List<Car> cars) {
        Set<String> carNames = cars.stream()
                .map(car -> car.getName())
                .collect(Collectors.toSet());
        if (cars.size() != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
