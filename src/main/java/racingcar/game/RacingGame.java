package racingcar.game;

import java.util.List;
import racingcar.car.Car;

public class RacingGame {
    private final List<Car> cars;
    private int rounds;

    public RacingGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public boolean playOneRound() {
        if (hasNextRound()) {
            cars.forEach(Car::move);
            rounds--;
            return true;
        }

        return false;
    }

    private boolean hasNextRound() {
        return rounds > 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
    }
}
