package racingcar;

import racingcar.controller.GameController;
import racingcar.factory.GameFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameFactory gameFactory = new GameFactory(null);
        GameController gameController = new GameController(inputView, outputView, gameFactory);

        gameController.run();
    }
}
