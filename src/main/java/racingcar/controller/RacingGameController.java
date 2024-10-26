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
        RaceCars raceCars = RaceCars.fromNames(InputView.inputCarNames());
        AttemptCount attemptCount = AttemptCount.from(InputView.inputAttemptCount());
        return new RacingGame(raceCars, attemptCount);
    }

}
