package racingcar;

import racingcar.controller.InputController;
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

        RacingController racingController = new RacingController(inputController, resultView, winnerView);
        racingController.run();
    }
}
