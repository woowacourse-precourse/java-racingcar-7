package racingcar.model;

import java.util.List;

public class GameResult {
    private final List<Car> finalCarState;
    private final String allRoundResults;

    public GameResult(List<Car> finalCarState, String allRoundResults) {
        this.finalCarState = finalCarState;
        this.allRoundResults = allRoundResults;
    }

    public List<Car> getFinalCarState() {
        return finalCarState;
    }

    public String getAllRoundResults() {
        return allRoundResults;
    }
}
