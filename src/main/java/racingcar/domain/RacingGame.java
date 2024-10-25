package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RoundCount roundCount;
    private final ScoreBoard scoreBoard;

    public RacingGame(Cars cars, RoundCount roundCount, ScoreBoard scoreBoard) {
        this.cars = cars;
        this.roundCount = roundCount;
        this.scoreBoard = scoreBoard;
    }

    public ScoreBoard play() {
        runAllRounds();
        scoreBoard.recordWinners(cars.getWinnerNames());
        return scoreBoard;
    }

    private void runAllRounds() {
        roundCount.iterate(() -> {
            cars.moveAll();
            scoreBoard.recordRound(createRoundScores());
        });
    }

    private RoundScores createRoundScores() {
        List<CarState> carStates = cars.carList().stream()
                .map(each -> new CarState(each.getName(), each.getPosition()))
                .toList();
        return new RoundScores(carStates);
    }
}
