package racingcar.dto;

import java.util.List;

public class GameResult {
    private RoundResults roundResults;
    private List<String> winnerNames;

    public RoundResults getRoundResults() {
        return roundResults;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public void setRoundResults(RoundResults roundResults) {
        this.roundResults = roundResults;
    }

    public void setWinnerNames(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }
}
