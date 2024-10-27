package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {
    public List<Car> generateCars(List<String> carNames) {
        return carNames.stream().map(carName -> new Car(carName, 0)).collect(Collectors.toList());
    }
}
