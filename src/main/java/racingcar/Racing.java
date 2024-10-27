package racingcar;

import racingcar.domain.Cars;
import racingcar.view.Input;

public class Racing {

    private final Input input;

    public Racing(Input input) {
        this.input = input;
    }

    public void ready() {
        String rawCarNames = input.readCarNames();
        Cars cars = new Cars(rawCarNames);

        start(cars);
    }

    private void start(Cars cars) {
        int lap = 5;
        for (int i = 0; i < lap; i++) {
            cars.moveAll();
        }

        finish(cars);
    }

    private void finish(Cars cars) {
        cars.findWinners();
    }
}
