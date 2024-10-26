package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ResultChecker {
    public String checkResult(LinkedHashMap<String, Integer> gameEntry) {
        return getWinner(gameEntry);
    }

    private String getWinner(LinkedHashMap<String, Integer> gameEntry) {
        String winner = "";
        List<String> winnerList = checkScore(gameEntry);

        for (String carName : winnerList) {
            winner = winner + carName;
            winnerList.remove(carName);
            
            if (!winnerList.isEmpty()) {
                winner = winner + ",";
            }
        }
        return winner;
    }

    private List<String> checkScore(LinkedHashMap<String, Integer> gameEntry) {
        Integer winScore = getWinScore(gameEntry);
        List<String> winnerList = new ArrayList<>();

        for (String carName : gameEntry.keySet()) {
            if (gameEntry.containsValue(winScore)) {
                winnerList.add(carName);
            }
        }
        return winnerList;
    }

    private Integer getWinScore(LinkedHashMap<String, Integer> gameEntry) {
        Integer winScore = 0;
        for (String carName : gameEntry.keySet()) {
            if (gameEntry.get(carName) > winScore) {
                winScore = gameEntry.get(carName);
            }
        }
        return winScore;
    }
}
