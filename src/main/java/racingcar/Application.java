package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.util.Separator;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {

        RacingGameController racingGameController = new RacingGameController(
                new InputView(),
                new Separator());
        racingGameController.run();

    }
}
