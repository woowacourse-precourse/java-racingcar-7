package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(new InputView(), new OutputView());
        racingCarGame.run();
    }
}
