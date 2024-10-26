package racingcar.domain;

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
            RoundScores roundScores = participants.createRoundScores();
            scoreBoard.recordRound(roundScores);
        });
    }
}
