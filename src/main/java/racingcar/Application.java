package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.MoveStrategy;
import racingcar.model.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        RacingGameController controller = new RacingGameController(moveStrategy,inputView, outputView);
        controller.run();
    }
}
