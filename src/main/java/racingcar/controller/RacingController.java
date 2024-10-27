package racingcar.controller;

import java.util.List;
import racingcar.model.AttemptCount;
import racingcar.model.Cars;
import racingcar.model.valuegenerator.RandomValueGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = getCarNames();
        Cars cars = createCars(carNames);
        String count = getAttemptCount();
        AttemptCount attemptCount = new AttemptCount(count);

        repeatMovesUntilAttemptExhausted(attemptCount, cars);
    }

    private List<String> getCarNames() {
        return inputView.readCarNames();
    }

    private static Cars createCars(List<String> carNames) {
        return Cars.valueOf(carNames);
    }

    private String getAttemptCount() {
        return inputView.readAttemptCount();
    }

    private void repeatMovesUntilAttemptExhausted(AttemptCount attemptCount, Cars cars) {
        if (attemptCount.isCountZero()) {
            return;
        }
        attemptCount.decreaseCount();
        cars.move(randomValueGenerator);
        outputView.printExecutionResult(cars.getExecutionResult());
        repeatMovesUntilAttemptExhausted(attemptCount, cars);
    }
}
