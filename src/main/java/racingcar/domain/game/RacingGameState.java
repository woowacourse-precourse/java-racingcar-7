package racingcar.domain.game;

import java.util.List;
import racingcar.view.output.RoundView;

public class RacingGameState {
    private final List<RoundView> roundResults;
    private final List<String> winners;

    public RacingGameState(List<RoundView> roundResults, List<String> winners) {
        this.roundResults = roundResults;
        this.winners = winners;
    }

    public List<RoundView> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinners() {
        return winners;
    }
}
