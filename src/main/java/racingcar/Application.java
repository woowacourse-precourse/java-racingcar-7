package racingcar;

import racingcar.presentation.controller.RacingCarController;

public class Application {
    private static final RacingCarController racingCarController = new RacingCarController();

    public static void main(String[] args) {
        racingCarController.run();
    }
}
