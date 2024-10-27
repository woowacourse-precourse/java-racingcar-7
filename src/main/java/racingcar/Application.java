package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.util.parser.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final StringParser stringParser = new StringParser();
        final RaceGameController raceGameController = new RaceGameController(inputView, outputView, stringParser);

        raceGameController.run();
    }
}
