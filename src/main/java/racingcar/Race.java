package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int attempts;
    private final RaceResult raceResult;

    public Race(List<String> carNames, int attempts) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        this.attempts = attempts;
        this.raceResult = new RaceResult(cars);
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            playRound();
            raceResult.printRoundResult();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void printWinners() {
        raceResult.printWinners();
    }
}
