package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<RoundResult> roundResult;
    private String winner;

    public GameResult() {
        this.roundResult = new ArrayList<>();
        this.winner = "";
    }

    public List<RoundResult> getRoundResult() {
        return this.roundResult;
    }

    public String getWinner() {
        return winner;
    }

    public void saveRoundResult(RoundResult roundResult) {
        this.roundResult.add(roundResult);
    }

    public void saveWinner(String winners) {
        this.winner = winners;
    }
}

