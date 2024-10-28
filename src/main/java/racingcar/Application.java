package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.service.GameService;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(new ConsoleInputView(), new ConsoleOutputView(), new GameService());
        racingCarGame.run();
    }
}
