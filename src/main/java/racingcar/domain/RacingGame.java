package racingcar.domain;

import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    private List<Car> cars;
    private int roofCount;
    OutputView outputView = new OutputView();

    public RacingGame(List<Car> cars, int roofCount) {
        this.cars = cars;
        this.roofCount = roofCount;
    }

    public void startRacing() {
        for (int i = 0; i < roofCount; i++) {
            for (Car car : cars) {
                car.tryMove();
            }
            outputView.printCurrentResult(cars);
        }
    }
}
