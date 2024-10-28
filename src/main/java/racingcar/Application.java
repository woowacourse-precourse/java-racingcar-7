package racingcar;

import racingcar.controller.RacingController;
import racingcar.util.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final StringParser stringParser = new StringParser();
        final RacingController racingController = new RacingController(inputView, outputView, stringParser);

        racingController.run();
    }
}
