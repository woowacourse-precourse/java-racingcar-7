package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameExecutor {
    private final List<Car> cars = new ArrayList<>();
    private final int attempts;
    private final OutputHandler outputHandler;

    public GameExecutor(List<String> carNames, int attempts, OutputHandler outputHandler) {
        for (String name : carNames) {
            cars.add(new Car(name, new RandomNumberGenerator()));
        }
        this.attempts = attempts;
        this.outputHandler = outputHandler;
    }

    public void execute() {
        for (int i = 0; i < attempts; i++) {
            playRound();
            outputHandler.displayRoundResults(cars);
        }
        outputHandler.displayWinners(cars);
    }

    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }
}
