package racingcar.domain;

import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play(final int attempts) {
        for (int i = 0; i < attempts; i++) {
            race();
            ResultView.printRaceStatus(cars);
        }
        ResultView.printWinners(cars);
    }

    private void race() {
        for (final Car car : cars) {
            car.move();
        }
    }
}
