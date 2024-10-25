package racingcar.generator;

import java.util.List;
import racingcar.domain.Car;

public interface RacingCarWinnerGenerator {
    public List<Car> generateWinner(List<Car> racingCars);
}
