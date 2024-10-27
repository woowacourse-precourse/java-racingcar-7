package racingcar.domain.car;

import java.util.List;
import racingcar.io.output.Output;
import racingcar.util.Random;

public class CarService {

    private final Random random;

    public CarService(Random random) {
        this.random = random;
    }

    public List<Car> getCars(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .toList();
    }

    public void incrementMoveCount(Car car) {
        int range = random.pickNumberInRange();

        if (range > 3) {
            car.addMoveCount();
        }

        Output.playerResult(car.getName(), range);
    }
}
