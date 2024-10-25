package racingcar.util.generator;

import java.util.List;
import racingcar.domain.RacingCar;

public interface RacingCarWinnerGenerator {
    public List<RacingCar> generateWinner(List<RacingCar> racingCars);
}
