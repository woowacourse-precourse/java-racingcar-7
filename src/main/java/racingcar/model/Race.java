package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final List<Car> cars;

    public Race(List<String> carNames) {
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public void playRound() {
        for (Car car : cars) {
            if (car.shouldMove()) {
                car.move();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}