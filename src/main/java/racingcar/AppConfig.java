package racingcar;

import racingcar.controller.RacingGame;
import racingcar.parser.InputParser;
import racingcar.parser.InputParserFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public RacingGame racingGame() {
        return new RacingGame(inputView(), inputParser(), outputView());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public InputParser inputParser() {
        return InputParserFactory.create();
    }
}
