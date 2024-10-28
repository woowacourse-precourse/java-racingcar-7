package racingcar;

import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void startRace(int attempts) {
        for (int i = 0; i < attempts; ++i) {
            for (Car car : cars) {
                car.move();
            }
        }
    }
}