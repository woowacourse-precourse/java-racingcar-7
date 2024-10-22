package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Cars cars = Cars.from(InputView.inputCarNames());
    }
}
