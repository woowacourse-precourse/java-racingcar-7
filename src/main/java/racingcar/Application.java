package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarRaceController carRaceController = new CarRaceController(
                new InputView(),
                new OutputView(),
                new RandomMoveStrategy());

        carRaceController.run();
    }
}
