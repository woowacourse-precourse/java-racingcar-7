package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> cars;
    private final int attempts;
    private int currentRound;

    public Game(List<String> carNames, MoveStrategy moveStrategy, int attempts) {
        this.cars = carNames.stream()
                .map(name -> new Car(name, moveStrategy))
                .collect(Collectors.toList());
        this.attempts = attempts;
        this.currentRound = 0;
    }

    public void playRound() {
        if (currentRound >= attempts) {
            return;
        }

        cars.forEach(Car::move);
        currentRound++;
    }

    public boolean isFinished() {
        return currentRound >= attempts;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
