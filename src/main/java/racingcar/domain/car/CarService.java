package racingcar.domain.car;

import java.util.List;
import racingcar.util.Random;

public class CarService {

    private static final int RANGE_CONDITION = 3;
    private final Random random;

    public CarService(Random random) {
        this.random = random;
    }

    public List<Car> getCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public int incrementMoveCount(Car car) {
        int range = random.pickNumberInRange();

        if (range > RANGE_CONDITION) {
            car.addMoveCount();
        }

        return range;
    }
}
