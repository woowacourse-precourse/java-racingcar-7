package racingcar.common.filter.executor;

import racingcar.model.RacingCarList;

public class RaceExecutor {
    public void executeRace(RacingCarList racingCarList, int iterations) {
        for (int i = 1; i <= iterations; i++) {
            racingCarList.moveAll();
        }
    }
}