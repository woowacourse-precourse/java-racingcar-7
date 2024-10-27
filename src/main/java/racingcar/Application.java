package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.move.MoveStrategy;
import racingcar.model.move.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingGameController racingGameController = initGameController();
        racingGameController.start();
    }

    private static RacingGameController initGameController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        return new RacingGameController(inputView, outputView, moveStrategy);
    }
}
