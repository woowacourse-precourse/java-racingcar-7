package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.input.RacingGameInput;
import racingcar.view.output.OutputView;
import racingcar.view.output.RacingGameOutPutView;

public class Application {
    public static void main(String[] args) {
        RacingGameInput inputView = new RacingGameInput();
        OutputView outputView = new RacingGameOutPutView();

        RacingGameController controller = new RacingGameController(inputView, outputView);
        controller.start();
    }
}
