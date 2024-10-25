package racingcar;

import java.util.ArrayList;
import racingcar.domain.RacingCarList;
import racingcar.domain.RandomMoveStrategy;

public class AppConfig {
    public RacingCarList racingCarList() {
        return new RacingCarList(new ArrayList<>(), randomMoveStrategy());
    }

    public RandomMoveStrategy randomMoveStrategy() {
        return new RandomMoveStrategy();
    }

}
