package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RacingGameModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGameModel racingGameModel = new RacingGameModel();
        RacingGameController racingGameController = new RacingGameController(inputView, outputView, racingGameModel);

        racingGameController.run();
    }
}
