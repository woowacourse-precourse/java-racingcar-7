package racingcar;

import racingcar.controller.GameController;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ConsoleView view = new ConsoleView();
        GameController controller = new GameController(view);
        controller.startGame();
    }
}
