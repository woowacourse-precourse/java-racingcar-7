package racingcar.global.util;

import java.util.Random;
import racingcar.global.io.SettingCondition;

public class RandomMaker {

    private static final Random random = new Random();
    private static int min = SettingCondition.RANDOM_MIN;
    private static int max = SettingCondition.RANDOM_MAX;

    public static int getRandomValue() {
        return min + random.nextInt(max - min + 1);
    }
}