package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        RacingCarController controller = new RacingCarController(input, output);
        controller.startGame();
    }
}
