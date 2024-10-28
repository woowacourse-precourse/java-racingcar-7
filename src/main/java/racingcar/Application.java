package racingcar;

import racingcar.controller.RacingGameController;

public class Application {
    private final RacingGameController racingGameController;
    public Application(RacingGameController racingGameController) {
        this.racingGameController = racingGameController;
    }
    public void run() {
        racingGameController.run();
    }
    public static void main(String[] args) {
        Application app = new Application(new RacingGameController());
        app.run();
    }
}
