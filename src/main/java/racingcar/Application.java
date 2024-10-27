package racingcar;

import racingcar.controller.RacingGame;
import racingcar.parser.InputParserFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
//        RacingGame racingGame = new RacingGame(new InputView(), InputParserFactory.create(), new OutputView());
        AppConfig appConfig = new AppConfig();
        RacingGame racingGame = appConfig.racingGame();
        racingGame.startRace();
    }
}
