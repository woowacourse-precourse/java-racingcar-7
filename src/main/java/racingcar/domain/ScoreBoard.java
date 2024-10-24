package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public record ScoreBoard(List<RoundScores> roundScoresList, List<String> winners) {

    public static ScoreBoard ofEmpty() {
        return new ScoreBoard(new ArrayList<>(), new ArrayList<>());
    }

    public void recordRound(RoundScores roundScores) {
        roundScoresList.add(roundScores);
    }

    public void recordWinners(List<String> winnerList) {
        winners.addAll(winnerList);
    }
}
