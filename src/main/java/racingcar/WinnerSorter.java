package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinnerSorter {

    public static List<String> getJointWinners(TreeMap<String, Integer> forwardCounter) {

        List<String> winnerList = new ArrayList<>();
        String winner = Collections.max(forwardCounter.entrySet(), Map.Entry.comparingByValue()).getKey();
        Integer winnerValue = forwardCounter.get(winner);

        for (Map.Entry<String, Integer> entry : forwardCounter.entrySet()) {
            String carName = entry.getKey();
            Integer forwardCount = entry.getValue();
            addJointWinner(carName, forwardCount, winnerValue, winnerList);
        }

        return winnerList;
    }

    static void addJointWinner(String carName, Integer forwardCount, Integer winnerValue, List<String> winnerList) {

        if(forwardCount > winnerValue) {
            throw new IllegalArgumentException();
        }

        if(forwardCount.equals(winnerValue)) {
            winnerList.add(carName);
        }
    }
}
