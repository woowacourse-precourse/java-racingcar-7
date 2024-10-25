package racingcar.domain;

public class RacingGame {

    private final Cars cars;
    private final ProgressManagement progressManagement;
    private final NumberGenerator numberGenerator;

    public RacingGame(Cars cars, int tryCount, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.progressManagement = new ProgressManagement(tryCount);
        this.numberGenerator = numberGenerator;
    }

    public void moveCars() {
        cars.moveCars(numberGenerator);
        progressManagement.incrementTryCount();
    }

    public boolean isProgress() {
        return progressManagement.isProgress();
    }
}
