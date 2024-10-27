package racingcar.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.strategy.MoveStrategy;

public class CarFactory {
    public List<Car> createCars(List<String> carNames, MoveStrategy moveStrategy) {
        return carNames.stream()
                .map(carName -> new Car(moveStrategy, carName))
                .collect(Collectors.toList());
    }
}
