package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WinnerDetermination {

    public List<String> determineWinners(Map<String, Integer> carScores) {
        int maxScore = findMaxScore(carScores);
        return findWinners(carScores, maxScore);
    }

    private int findMaxScore(Map<String, Integer> carScores) {
        int maxScore = 0;
        for (int score : carScores.values()) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return maxScore;
    }

    private List<String> findWinners(Map<String, Integer> carScores, int maxScore) {
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : carScores.entrySet()) {
            if (entry.getValue() == maxScore) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }
}
