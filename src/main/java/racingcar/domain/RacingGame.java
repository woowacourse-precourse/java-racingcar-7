package racingcar.domain;

public class RacingGame {

    private final Cars cars;
    private final ProgressManagement progressManagement;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.progressManagement = new ProgressManagement(tryCount);
    }

    public void moveCars() {
        cars.moveCars();
        progressManagement.incrementTryCount();
    }

    public boolean isProgress() {
        return progressManagement.isProgress();
    }
}
