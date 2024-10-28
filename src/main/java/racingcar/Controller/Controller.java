package racingcar.Controller;

import racingcar.Domain.RacingGame;
import racingcar.ViewInterface.InputView;
import racingcar.ViewInterface.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame game = new RacingGame(inputView, outputView);
        game.play();
    }
}

