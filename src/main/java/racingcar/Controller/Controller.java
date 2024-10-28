package racingcar.Controller;

import racingcar.Domain.RacingGame;
import racingcar.Viewinterface.InputView;
import racingcar.Viewinterface.OutputView;

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

