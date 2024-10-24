package racingcar;

import java.util.HashSet;
import java.util.Set;

public class RacingGame {
    Set<Car> cars = new HashSet<>();

    public void run(final String carNames) {
        for (String name : carNames.split(",")) {
            Car car = new Car(name);
            cars.add(car);
        }
    }
}
