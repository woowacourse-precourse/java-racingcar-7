package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomEngine implements Engine {
    private static final int MAX_ENGINE_POWER = 10;
    private static final int IS_ENGINE_RUNNING_MINIMUM_POWER = 4;

    @Override
    public boolean isEngineRunning() {
        return runEngine() >= IS_ENGINE_RUNNING_MINIMUM_POWER;
    }

    public int runEngine() {
        return Randoms.pickNumberInRange(0, MAX_ENGINE_POWER);
    }
}
