package racingcar.service;


import racingcar.domain.Car;
import racingcar.view.View;

import java.util.List;

public class RaceManager {
    private final View view;
    private final List<Car> cars;
    private final int round;

    public RaceManager(View view, List<Car> cars, int round) {
        this.view = view;
        this.cars = cars;
        this.round = round;
    }

    public void playRoundUntilRoundCount() {
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                car.attemptMoveForward();
            }
            view.displayRoundResults(cars);
            System.out.println();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }
}
