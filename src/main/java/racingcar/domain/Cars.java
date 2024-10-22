package racingcar.domain;

import static racingcar.exception.ExceptionMessage.DUPLICATE_CARS;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars) {
        checkDuplicateCars(cars);
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void checkDuplicateCars(List<String> cars) {
        Map<String, Long> duplicateCars = cars.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if(!duplicateCars.isEmpty()) {
            throw new IllegalArgumentException(DUPLICATE_CARS.getMessage());
        }
    }
}
