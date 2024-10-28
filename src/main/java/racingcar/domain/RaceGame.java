package racingcar.domain;

import racingcar.utils.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private final List<Car> cars = new ArrayList<>();
    private final int attemptCount;

    public RaceGame(List<String> carNames, int attemptCount) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.attemptCount = attemptCount;
    }

    public void startRace() {
        OutputHandler outputHandler = new OutputHandler();

        for (int i = 0; i < attemptCount; i++) {
            playRound();
            outputHandler.printRoundResults(cars);
        }
    }

    public void playRound() {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
