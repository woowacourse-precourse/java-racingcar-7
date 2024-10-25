package racingcar;

import racingcar.view.View;
import racingcar.controller.RacingcarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        var view = new View();
        var racingcarController = new RacingcarController(view);

        racingcarController.run();
    }
}
