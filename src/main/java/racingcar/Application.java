package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.io.Input;
import racingcar.io.Output;

public class Application {
    public static void main(String[] args) {
        Output output = Output.getInstance();
        Input input = Input.getInstance();
        RacingcarController racingcarController = new RacingcarController(output, input);
        racingcarController.playRacingcarGame();
    }
}
