package racingcar;

import racingcar.controller.GameContoller;

public class Application {
    public static void main(String[] args) {
        GameContoller gameContoller = new GameContoller();
        gameContoller.run();
    }
}
