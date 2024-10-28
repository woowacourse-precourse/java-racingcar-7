package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.domain.RacingGame;
import racingcar.views.InputView;

public class RacingGameController {

    public void run() {
        String input = InputView.inputString();
        int count = InputView.inputTryCount();
        RacingGame game = new RacingGame(input);
        game.play(count);
    }
}
