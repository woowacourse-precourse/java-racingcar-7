package racingcar;

import java.util.List;

public class CarGame {
    private List<Car> cars;
    private Input input;

    public void run() {
        cars = input.carNames();
        int cnt = input.tryCount();

    }
}
