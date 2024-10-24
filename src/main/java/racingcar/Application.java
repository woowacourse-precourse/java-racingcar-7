package racingcar;

import racingcar.controller.RacingController;
import racingcar.utils.StringSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringSplitter stringSplitter = new StringSplitter();

        RacingController racingController = new RacingController(inputView, outputView, stringSplitter);
        racingController.run();
    }
}
