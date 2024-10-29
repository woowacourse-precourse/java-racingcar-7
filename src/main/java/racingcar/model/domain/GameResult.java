package racingcar.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameResult {
    private final List<RoundResult> roundResults = new ArrayList<>();
    private List<String> winners;

    public void saveRound(Cars cars) {
        roundResults.add(RoundResult.from(cars));
    }

    public void saveWinner(Cars cars) {
        winners = cars.findWinners();
    }

    public List<RoundResult> getRoundResults() {
        return new ArrayList<>(roundResults);
    }

    public List<String> getWinners() {
        return winners;
    }
}
