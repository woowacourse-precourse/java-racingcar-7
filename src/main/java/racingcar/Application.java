package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        GameController controller = new GameController(input, output);

        controller.run();
    }
}
