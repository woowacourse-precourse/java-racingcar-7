package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.util.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Validation validation = new Validation();
        InputView inputView = new InputView(validation);
        OutputView outputView = new OutputView();
        RacingGameController racingGame = new RacingGameController(inputView, outputView);

        racingGame.start();
    }
}
