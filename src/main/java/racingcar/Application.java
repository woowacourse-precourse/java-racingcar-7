package racingcar;

import racingcar.controller.InputController;
import racingcar.controller.OutputController;
import racingcar.controller.RacingController;
import racingcar.view.InputCarNamesView;
import racingcar.view.InputTurnCountView;
import racingcar.view.ResultView;
import racingcar.view.WinnerView;

public class Application {

    public static void main(String[] args) {

        InputCarNamesView inputCarNamesView = new InputCarNamesView();
        InputTurnCountView inputTurnCountView = new InputTurnCountView();
        InputController inputController = new InputController(inputCarNamesView, inputTurnCountView);

        ResultView resultView = new ResultView();
        WinnerView winnerView = new WinnerView();
        OutputController outputController = new OutputController(resultView, winnerView);

        RacingController racingController = new RacingController(inputController, outputController);
        racingController.run();
    }
}
