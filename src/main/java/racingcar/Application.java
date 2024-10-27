package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        OutputView output = new OutputView();

        RacingCarController racingCarController = new RacingCarController(input, output);
        racingCarController.run();
    }
}
