package racingcar.Controller;

import racingcar.Domain.RacingGame;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Controller {
    private InputView inputView;
    private OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame game = new RacingGame(inputView, outputView);
        game.play();
    }
}
