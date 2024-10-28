package racingcar.common.filter.mock;

import racingcar.common.filter.executor.RaceExecutor;
import racingcar.model.RacingCarList;

public class MockRaceExecutor extends RaceExecutor {
    private boolean executed = false;

    @Override
    public void executeRace(RacingCarList racingCarList, int iterations) {
        executed = true;
    }

    public boolean isExecuted() {
        return executed;
    }
}

