package racingcar.global.util;

import java.util.Random;
import racingcar.global.io.Condition;

public class RandomMaker {

    private static final Random random = new Random();
    private static int min = Condition.RANDOM_MIN;
    private static int max = Condition.RANDOM_MAX;

    public static int getRandomValue() {
        return min + random.nextInt(max - min + 1);
    }
}