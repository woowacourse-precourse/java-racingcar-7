package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        try {
            RacingCarController controller = new RacingCarController();
            controller.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}