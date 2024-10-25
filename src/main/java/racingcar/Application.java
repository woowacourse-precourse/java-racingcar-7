package racingcar;

import racingcar.mvc.controller.RacingGameController;
import racingcar.mvc.view.InputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGame = RacingGameController.getInstance();

        racingGame.setInputView(new InputView());

        racingGame.run();
    }
}
