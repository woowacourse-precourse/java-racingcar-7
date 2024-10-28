package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private static final List<Car> racingCars = new ArrayList<>();

    public static CarRacingGame create(List<String> carNames) {
        for (String carName : carNames) {
            racingCars.add(Car.create(carName));
        }
        return new CarRacingGame();
    }
}
