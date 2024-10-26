package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private Cars cars;
    private AttemptCount attemptCount;
    private List<List<CarSnapshot>> roundResults;

    public RacingGame(Cars cars, AttemptCount attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
        this.roundResults = new ArrayList<>();
    }

    public void play() {
        for (int i = 0; i < attemptCount.getAttemptCount(); i++) {
            cars.moveCars();
            saveRoundResult();
        }
    }

    private void saveRoundResult() {
        List<CarSnapshot> currentRound = cars.getAllCars().stream()
                .map(CarSnapshot::new)
                .toList();
        roundResults.add(currentRound);
    }

    public List<List<CarSnapshot>> getRoundResults() {
        return roundResults;
    }
}
