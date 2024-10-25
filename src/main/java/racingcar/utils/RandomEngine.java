package racingcar.utils;

import java.util.Random;

public class RandomEngine implements Engine{
    private static final int MAX_ENGINE_POWER = 10;
    private static final int IS_ENGINE_RUNNING_MINIMUM_POWER = 4;

    @Override
    public boolean isEngineRunning() {
        return runEngine() >= IS_ENGINE_RUNNING_MINIMUM_POWER; // runEngine()의 결과가 4 이상이면 true, 아니면 false
    }

    public int runEngine() {
        Random random = new Random();
        return random.nextInt(MAX_ENGINE_POWER);
    }
}
