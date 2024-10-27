package racingcar;

import racingcar.model.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(
                new InputView(),
                new OutputView()
        );
        racingGameController.run();
    }
}
