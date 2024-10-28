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

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
