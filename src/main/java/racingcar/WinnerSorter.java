package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinnerSorter {

    public List<String> getJointWinners(TreeMap<String, Integer> forwardCounter) {
        List<String> winnerList = new ArrayList<>();
        String winner = Collections.max(forwardCounter.entrySet(), Map.Entry.comparingByValue()).getKey();
        Integer winnerCount = forwardCounter.get(winner);

        for (Map.Entry<String, Integer> entry : forwardCounter.entrySet()) {
            String carName = entry.getKey();
            Integer forwardCount = entry.getValue();
            addJointWinner(carName, forwardCount, winnerCount, winnerList);
        }

        return winnerList;
    }

    void addJointWinner(String carName, Integer forwardCount, Integer winnerCount, List<String> winnerList) {
        if (forwardCount > winnerCount) {
            throw new IllegalArgumentException();
        }

        if (forwardCount.equals(winnerCount)) {
            winnerList.add(carName);
        }
    }
}
