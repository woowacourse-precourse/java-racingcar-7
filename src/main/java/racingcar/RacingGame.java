package racingcar;

import java.util.List;

public class RacingGame {

    private final InputReceiver inputReceiver;

    public RacingGame(InputReceiver inputReceiver) {
        this.inputReceiver = inputReceiver;
    }

    public void run() {
        List<String> carNames = inputReceiver.readCarNames();
        long attemptNumber = inputReceiver.readAttemptNumber();

        Racing racing = new Racing(createCars(carNames), attemptNumber);
        racing.race();
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }
}
