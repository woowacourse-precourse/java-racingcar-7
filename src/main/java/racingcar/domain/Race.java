package racingcar.domain;

import racingcar.domain.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
    }

    public void raceRound(MovableStrategy strategy) {
        for (Car car : cars) {
            if (strategy.shouldMove()) {
                car.move();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
