package racingcar;

import java.util.*;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void startRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            ResultView.printPositions(cars);
        }
        ResultView.announceWinners(cars);
    }
}
