package racingcar;

import racingcar.mvc.controller.RacingGameController;
import racingcar.mvc.controller.racingGameManager.CarRacingGameManager;
import racingcar.mvc.view.InputView;
import racingcar.mvc.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController carRacingGame = RacingGameController.getInstance();

        carRacingGame.setInputView(new InputView());
        carRacingGame.setOutputView(new OutputView());
        carRacingGame.setRacingGameManager(new CarRacingGameManager());

        carRacingGame.run();
    }
}
