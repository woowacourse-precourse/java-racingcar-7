package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> createCars(String carsName) {
        return List.of(carsName.split(",")).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
