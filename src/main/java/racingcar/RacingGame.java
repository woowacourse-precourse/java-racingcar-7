package racingcar;

import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int attempts;

    public void start() {
        this.cars = InputView.getCars();
        this.attempts = InputView.getAttemptCount();

        OutputView.printStartMessage();
        runRounds();
    }

    private void runRounds() {
        for (int i = 0; i < attempts; i++) {
            cars.forEach(Car::move);
            OutputView.printRoundResult(cars);
        }
    }
}
