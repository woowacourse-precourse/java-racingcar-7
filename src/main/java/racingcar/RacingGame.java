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
        declareWinners();
    }

    private void runRounds() {
        for (int i = 0; i < attempts; i++) {
            cars.forEach(Car::move);
            OutputView.printRoundResult(cars);
        }
    }

    private void declareWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
        OutputView.printWinners(winners);
    }
}