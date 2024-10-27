package racingcar.car;

import java.util.List;
import racingcar.util.Random;

public class CarService {

    private final Random random;

    public CarService(Random random) {
        this.random = random;
    }

    public static List<Car> getCars(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .toList();
    }

    public void incrementMoveCount(Car car) {
        int range = random.pickNumberInRange();

        if (range > 3) {
            car.addMoveCount();
        }
    }
}
