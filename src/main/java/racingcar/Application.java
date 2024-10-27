package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame racingGame = new RacingGame(new InputView(), new ResultView());

        racingGame.run();
    }
}
