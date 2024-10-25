package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars participants;
    private final RoundCount roundCount;
    private final ScoreBoard scoreBoard;

    public RacingGame(Cars participants, RoundCount roundCount, ScoreBoard scoreBoard) {
        this.participants = participants;
        this.roundCount = roundCount;
        this.scoreBoard = scoreBoard;
    }

    public ScoreBoard play() {
        runAllRounds();
        scoreBoard.recordWinners(participants.getWinnerNames());
        return scoreBoard;
    }

    private void runAllRounds() {
        roundCount.iterate(() -> {
            participants.moveAll();
            scoreBoard.recordRound(createRoundScores());
        });
    }

    private RoundScores createRoundScores() {
        List<CarState> carStates = participants.carList().stream()
                .map(each -> new CarState(each.getName(), each.getPosition()))
                .toList();
        return new RoundScores(carStates);
    }
}
