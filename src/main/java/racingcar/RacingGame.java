package racingcar;

import java.util.List;

public class RacingGame {
    private List<Car> cars;

    public void start() {
        this.cars = InputView.getCars();
        // 이후 로직은 다음 기능에서 구현
    }
}
