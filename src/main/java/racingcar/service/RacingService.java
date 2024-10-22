package racingcar.service;

import racingcar.util.RandomUtil;

import java.util.List;

public class RacingService {
    public static void moveOrStop(List<Integer> moveCounts) {
        for (int i = 0; i < moveCounts.size(); i++) {
            int randomNumber = RandomUtil.getRandomNumber();
            if (randomNumber >= 4) {
                moveCounts.set(i, moveCounts.get(i) + 1);
            }
        }
    }
}
