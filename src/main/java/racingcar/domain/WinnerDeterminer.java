package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerDeterminer {

    public List<String> determineWinner(HashMap<String, Integer> racingLog, List<String> carNameList) {

        ArrayList<String> winnerList = new ArrayList<>();
        int maxMoveCount = getMaxMoveCount(racingLog);

        for (String carName : carNameList) {
            Integer moveCount = racingLog.get(carName);
            if (maxMoveCount == moveCount) {
                winnerList.add(carName);
            }
        }
        return winnerList;
    }

    private int getMaxMoveCount(HashMap<String, Integer> racingLog) {
        int maxMoveCount = 0;
        for (Map.Entry<String, Integer> entry : racingLog.entrySet()) {
            maxMoveCount = Math.max(maxMoveCount, entry.getValue());
        }
        return maxMoveCount;
    }
}
