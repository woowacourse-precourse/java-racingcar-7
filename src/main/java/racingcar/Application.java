package racingcar;

import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            RacingGameController controller = new RacingGameController();
            controller.startGame();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
