package racingcar.util.selector;

import java.util.List;
import racingcar.domain.RacingCar;

public interface RacingCarGameWinnerSelector {
    public List<RacingCar> generateWinner(List<RacingCar> racingCars);
}
