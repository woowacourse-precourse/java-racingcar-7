package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.io.Output;

public class Application {
    public static void main(String[] args) {
        Output output = Output.getInstance();
        RacingcarController racingcarController = new RacingcarController(output);
        racingcarController.playRacingcarGame();
    }
}
