package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class RacingService {
    public List<Car> convertNamesToCars(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
