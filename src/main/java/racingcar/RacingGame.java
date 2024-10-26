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
            // 각 라운드에서 자동차 이동은 다음 기능에서 구현
            OutputView.printRoundResult(cars);
        }
    }
}
