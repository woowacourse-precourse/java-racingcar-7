package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.controller.strategy.MoveStrategy;
import racingcar.controller.strategy.RandomMoveStrategy;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.input.InputView;
import racingcar.view.output.ConsoleOutputView;
import racingcar.view.output.OutPutView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new ConsoleInputView();
        final OutPutView outputView = new ConsoleOutputView();
        final MoveStrategy moveStrategy = new RandomMoveStrategy(0, 9, 4);
        final RacingCarController racingCarController = new RacingCarController(inputView, outputView, moveStrategy);

        racingCarController.startRace();
    }
}
