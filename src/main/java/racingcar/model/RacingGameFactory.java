package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameFactory {
    public RacingGame createGame(String[] carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingGame(cars);
    }
}
