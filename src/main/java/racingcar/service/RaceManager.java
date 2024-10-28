package racingcar.service;


import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.List;

public class RaceManager {
    private final OutputView outputView;
    private final List<Car> cars;
    private final int round;

    public RaceManager(OutputView outputView, List<Car> cars, int round) {
        this.outputView = outputView;
        this.cars = cars;
        this.round = round;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }

    public void playRoundUntilRoundCount() {
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                car.attemptMoveForward();
            }
            outputView.displayRoundResults(cars);
            System.out.println();
        }
    }
}
