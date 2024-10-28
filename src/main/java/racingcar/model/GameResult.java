package racingcar.model;

import java.util.Map;

public class GameResult {
    private final Map<String, Integer> finalCarState;
    private final String allRoundResults;

    public GameResult(Map<String, Integer> finalCarState, String allRoundResults) {
        this.finalCarState = finalCarState;
        this.allRoundResults = allRoundResults;
    }

    public Map<String, Integer> getFinalCarState() {
        return finalCarState;
    }

    public String getAllRoundResults() {
        return allRoundResults;
    }
}
