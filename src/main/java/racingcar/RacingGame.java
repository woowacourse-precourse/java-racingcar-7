package racingcar;

import java.util.List;

public class RacingGame {

    private final InputReceiver inputReceiver;
    private final ResultLogger resultLogger;

    public RacingGame(InputReceiver inputReceiver, ResultLogger resultLogger) {
        this.inputReceiver = inputReceiver;
        this.resultLogger = resultLogger;
    }

    public void run() {
        List<String> carNames = inputReceiver.readCarNames();
        long attemptNumber = inputReceiver.readAttemptNumber();

        Racing racing = new Racing(createCars(carNames), attemptNumber);
        List<String> winners = racing.race();

        resultLogger.print(racing.getResult(), racing.getAttemptNumber(), winners);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }
}
