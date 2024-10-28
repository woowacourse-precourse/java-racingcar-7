package racingcar.service;

import java.util.List;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.model.TryCount;

public class RacingGame {
    private final Cars cars;
    private final TryCount tryCount;

    public RacingGame(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<String> getFinalWinner() {
        return cars.getFinalWinners().stream()
                .map(CarName::getName)
                .toList();
    }

    public String getRacingResult() {
        return cars.getGameResult();
    }

    public void runAllCycle() {
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            runOneCycle();
        }
    }

    private void runOneCycle() {
        cars.moveAllCars();
    }
}
