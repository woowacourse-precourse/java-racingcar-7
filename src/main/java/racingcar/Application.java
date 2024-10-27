package racingcar;

import racingcar.controller.InputController;
import racingcar.controller.RacingController;
import racingcar.view.InputCarNamesView;
import racingcar.view.InputTurnCountView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {

        InputCarNamesView inputCarNamesView = new InputCarNamesView();
        InputTurnCountView inputTurnCountView = new InputTurnCountView();
        InputController inputController = new InputController(inputCarNamesView, inputTurnCountView);

        OutputView outputView = new OutputView();

        RacingController racingController = new RacingController(inputController, outputView);
        racingController.run();
    }
}
