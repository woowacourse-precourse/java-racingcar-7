package racingcar.model;

import java.util.List;

public class GameResult {
    private final List<List<RacingCar>> progress;
    private final List<RacingCar> winners;

    public GameResult(List<List<RacingCar>> progress, List<RacingCar> winners) {
        this.progress = progress;
        this.winners = winners;
    }

    public List<List<RacingCar>> getProgress() {
        return progress;
    }

    public List<RacingCar> getWinners() {
        return winners;
    }
}
