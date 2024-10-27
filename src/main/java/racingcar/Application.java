package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Cars cars = Cars.from(InputView.readNames());
        int repeatCount = InputView.readRepeatCount();
        Cars test = new Cars(List.of(new Car("pobi", 1), new Car("woni", 0)));
        OutputView.renderCars(test);
        OutputView.renderWinner(test);
    }
}
