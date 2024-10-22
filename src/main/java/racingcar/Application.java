package racingcar;

import racingcar.domain.Cars;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Cars cars = Cars.from(InputView.inputCarNames());
        final int round = InputView.inputRound();

        for (int i = 0; i < round; i++) {
            cars.racing(new RandomMoveStrategy());
        }
    }
}
