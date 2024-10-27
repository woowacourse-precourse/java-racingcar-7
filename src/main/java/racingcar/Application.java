package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Cars cars = Cars.from(InputView.readNames());
        int repeatCount = InputView.readRepeatCount();
        OutputView.renderCars(cars);
    }
}
