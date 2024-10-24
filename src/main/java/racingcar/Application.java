package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
        Console.close();
    }
}
