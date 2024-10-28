package racingcar.gameplayer.game.racinggame.app.dto;

import java.util.Comparator;
import java.util.List;
import racingcar.gameplayer.game.common.exception.CustomException;
import racingcar.gameplayer.game.common.exception.ErrorMessage;

public record RoundResult(List<CarScore> scores, List<String> winner) {

    public static RoundResult of(List<CarScore> scores) {
        return new RoundResult(scores, initWinner(scores));
    }

    private static List<String> initWinner(List<CarScore> scores) {
        return getWinners(scores);
    }

    private static List<String> getWinners(List<CarScore> scores) {
        Long maxPosition = getMaxPosition(scores);
        return scores.stream()
            .filter(score -> score.position().equals(maxPosition))
            .map(CarScore::name)
            .toList();
    }

    private static Long getMaxPosition(List<CarScore> scores) {
        return scores.stream()
            .max(Comparator.comparing(CarScore::position))
            .map(CarScore::position)
            .orElseThrow(() -> new CustomException(ErrorMessage.INVALID_SCORE_STATUS));
    }
}
