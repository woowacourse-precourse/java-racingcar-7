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

        for (int i = 0; i < winnerList.size(); i++) {
            winner += winnerList.get(i);
            if (i < winnerList.size() - 1) {
                winner += ",";
            }
        }
        return winner;
    }

    private List<String> checkScore(LinkedHashMap<String, Integer> gameEntry) {
        Integer winScore = getWinScore(gameEntry);
        List<String> winnerList = new ArrayList<>();

        for (String carName : gameEntry.keySet()) {
            if (gameEntry.get(carName).equals(winScore)) {
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
