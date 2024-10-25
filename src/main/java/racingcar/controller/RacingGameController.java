package racingcar.controller;

import racingcar.model.AttemptCount;
import racingcar.model.RaceCars;
import racingcar.model.RacingGame;
import racingcar.view.InputView;


public class RacingGameController {

    public void startGame() {
        RacingGame racingGame = createRacingGame();
    }

    private RacingGame createRacingGame(){
        RaceCars raceCars = new RaceCars(InputView.inputCarNames());
        AttemptCount attemptCount = new AttemptCount(InputView.inputAttemptCount());
        return new RacingGame(raceCars, attemptCount);
    }

}
