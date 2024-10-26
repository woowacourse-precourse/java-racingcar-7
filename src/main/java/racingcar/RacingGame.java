package racingcar;

import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int attempts;

    public void start() {
        this.cars = InputView.getCars();
        this.attempts = InputView.getAttemptCount();
        // 이후 로직은 다음 기능에서 구현
    }
}
