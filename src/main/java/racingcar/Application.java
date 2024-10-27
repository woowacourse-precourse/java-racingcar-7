package racingcar;

import racingcar.controller.RacingGameManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameManager racingGameController = new RacingGameManager(
                new InputView(),
                new OutputView()
        );
        racingGameController.run();
    }
}
