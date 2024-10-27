package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinnerSorter {

    public List<String> getJointWinners(TreeMap<String, Integer> forwardCounter) {

        List<String> winnerList = new ArrayList<>();
        String winner = forwardCounter.lastKey();
        Integer winnerValue = forwardCounter.get(winner);

        for (Map.Entry<String, Integer> entry : forwardCounter.entrySet()) {
            String carName = entry.getKey();
            Integer forwardCount = entry.getValue();
            addJointWinner(carName, forwardCount, winnerValue, winnerList);
        }

        return winnerList;
    }

    private void addJointWinner(String carName, Integer forwardCount, Integer winnerValue, List<String> winnerList) {
        if(forwardCount.equals(winnerValue)) {
            winnerList.add(carName);
        }
    }
}
