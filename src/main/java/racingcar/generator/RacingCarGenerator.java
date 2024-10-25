package racingcar.generator;

import java.util.List;
import racingcar.domain.Car;

public interface RacingCarGenerator {
    public List<Car> generateCar(List<String> carNames);
}
