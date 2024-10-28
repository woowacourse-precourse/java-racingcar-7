package racingcar.gameplayer.game.racinggame.app.dto;

import java.util.List;

public record GameResult(List<RoundResult> results, List<String> winner) {

    public static GameResult of(List<RoundResult> results) {
        return new GameResult(results, getWinner(results));
    }

    private static List<String> getWinner(List<RoundResult> results) {
        return results.getLast().winner();
    }
}
