package racingcar;

import racingcar.controller.RacingGame;
import racingcar.parser.InputParser;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputView(), new InputParser(new InputValidator()), new OutputView());
        racingGame.startRace();
    }
}
