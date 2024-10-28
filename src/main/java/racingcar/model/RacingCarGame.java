package racingcar.model;

public class RacingCarGame {

    private int currentRound;
    private final RaceHistory raceHistory;
    private final Cars cars;
    private final int totalRounds;

    public RacingCarGame(Cars cars, int totalRounds) {
        raceHistory = new RaceHistory();
        this.cars = cars;
        this.totalRounds = totalRounds;
    }

    public void runRound() {
        if (isEnd()) {
            return;
        }

        cars.moveCarsAccordingToGameRule();
        raceHistory.recordRoundResult(cars);
        currentRound++;
    }

    public boolean isEnd() {
        return currentRound == totalRounds;
    }
}
