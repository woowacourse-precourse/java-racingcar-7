package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.input.RacingGameInputConsole;
import racingcar.view.output.OutputView;
import racingcar.view.output.RacingGameOutPutView;

public class Application {
    public static void main(String[] args) {
        RacingGameInputConsole inputView = new RacingGameInputConsole();
        OutputView outputView = new RacingGameOutPutView();

        RacingGameController controller = new RacingGameController(inputView, outputView);
        controller.start();
    }
}
