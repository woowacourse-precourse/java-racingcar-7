package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Cars cars = Cars.from(InputView.inputCarNames());
        final int round = InputView.inputRound();

        OutputView.printRacingResultMessage();
        for (int i = 0; i < round; i++) {
            cars.racing(new RandomMoveStrategy());
            OutputView.printRacingCars(cars);
        }

        OutputView.printRaceWinners(new Winners(cars));
    }
}
