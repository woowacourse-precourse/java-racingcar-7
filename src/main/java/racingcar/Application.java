package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.RacingGame;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame racingGame = new RacingGame();
        ConsoleView consoleView = new ConsoleView();
        RacingCarController controller = new RacingCarController(racingGame, consoleView);

        controller.run();
    }
}
