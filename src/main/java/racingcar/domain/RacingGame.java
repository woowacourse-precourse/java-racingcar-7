package racingcar.domain;

public class RacingGame {

    private final Cars cars;
    private final ProgressManagement progressManagement;
    private final MovementJudge movementJudge;

    public RacingGame(Cars cars, int tryCount, MovementJudge movementJudge) {
        this.cars = cars;
        this.progressManagement = new ProgressManagement(tryCount);
        this.movementJudge = movementJudge;
    }

    public void moveCars() {
        cars.moveCars(movementJudge);
        progressManagement.incrementTryCount();
    }

    public boolean isProgress() {
        return progressManagement.isProgress();
    }
}
