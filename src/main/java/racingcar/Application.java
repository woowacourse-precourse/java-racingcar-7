package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame racingGame = new RacingGame();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingController controller = new RacingController(racingGame, inputView, outputView);
        controller.run();
    }
}
