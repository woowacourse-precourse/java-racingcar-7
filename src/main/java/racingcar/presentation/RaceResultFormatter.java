package racingcar.presentation;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.CarState;
import racingcar.domain.game.RoundScores;
import racingcar.domain.game.ScoreBoard;

public class RaceResultFormatter {
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String NEW_LINE = "\n";
    private static final String POSITION_SYMBOL = "-";
    private static final String WINNER_NAME_SEPARATOR = ", ";
    private static final String WINNER_PREFIX = "최종 우승자 : ";

    public String formatScoreBoard(ScoreBoard scoreBoard) {
        StringBuilder formattedResult = new StringBuilder();
        scoreBoard.roundScoresList().forEach(each -> formattedResult.append(formatRound(each)));
        formattedResult.append(formatWinnerNames(scoreBoard.winners()));
        return formattedResult.toString();
    }

    private String formatRound(RoundScores roundScores) {
        return roundScores.carStates().stream()
                .map(this::formatSingleCarState)
                .collect(Collectors.joining())
                + NEW_LINE;
    }

    private String formatSingleCarState(CarState carState) {
        return carState.name()
                + NAME_POSITION_SEPARATOR
                + POSITION_SYMBOL.repeat(carState.position())
                + NEW_LINE;
    }

    private String formatWinnerNames(List<String> winnerNames) {
        return WINNER_PREFIX + String.join(WINNER_NAME_SEPARATOR, winnerNames) + NEW_LINE;
    }
}