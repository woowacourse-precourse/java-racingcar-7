package racingcar.util.generator;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class BasicRacingCarGenerator implements RacingCarGenerator{
    @Override
    public List<Car> generateCar(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
