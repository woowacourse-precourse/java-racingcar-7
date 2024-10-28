package racingcar.model;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void play(Runnable roundResultCallback) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            roundResultCallback.run();
        }
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}