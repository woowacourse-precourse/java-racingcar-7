package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> racingCars = new ArrayList<>();

    public void registerRacingCars(List<String> carNames) {
        carNames.stream()
                .map(Car::new)
                .forEach(racingCars::add);
    }
}
