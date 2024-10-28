package racingcar;

import java.util.List;
import java.util.Map;

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

        Map<Long, List<Record>> result = racing.race();
        List<String> winners = racing.selectWinnerNames();

        resultLogger.print(result, racing.getAttemptNumber(), winners);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }
}
