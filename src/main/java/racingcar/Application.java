package racingcar;

import racingcar.controller.RacingController;
import racingcar.util.StringParser;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final StringParser stringParser = new StringParser();
        final RacingController racingController = new RacingController(inputView, stringParser);

        racingController.run();
    }
}
