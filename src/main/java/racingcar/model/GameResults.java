package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResults {

    private final List<GameResult> gameResults;

    private GameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults of(List<GameResult> gameResults) {
        return new GameResults(gameResults);
    }

    public List<GameResult> getGameResults() {
        return new ArrayList<>(gameResults);
    }

}
