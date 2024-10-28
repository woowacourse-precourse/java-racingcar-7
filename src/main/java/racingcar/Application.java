package racingcar;

import racingcar.controller.RacingcarController;

public class Application {
    private static RacingcarController racingcarController = RacingcarController.getInstance();
    public static void main(String[] args) {
        racingcarController.playGame();
    }
}
