package racingcar.model.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<String> winners;
    private List<RoundResult> roundResults;

    public GameResult() {
        this.winners = new ArrayList<>();
        this.roundResults = new ArrayList<>();
    }

    public void recordRound(Cars cars) {
        RoundResult roundResult = RoundResult.from(cars);
        roundResults.add(roundResult);
    }

    public void recordWinner(Cars cars) {
        this.winners = cars.findWinners();
    }

    public List<String> getWinners() {
        return this.winners;
    }

    public List<RoundResult> getRoundResults() {
        return this.roundResults;
    }
}
