package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static int getMaxValueFromList(List<Integer> list) {
        int maxValue = 0;
        for (Integer value : list) {
            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }


    public static List<String> getWinnersByMoveCount(List<Integer> moveCounts, int MoveCount, List<String> carNames) {
        List<String> winnerNames = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            if (moveCounts.get(i) == MoveCount) winnerNames.add(carNames.get(i));
        }
        return winnerNames;
    }
}
