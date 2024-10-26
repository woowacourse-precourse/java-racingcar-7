package racingcar.controller;

import racingcar.model.AttemptCount;
import racingcar.model.RaceCars;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingGameController {

    public void startGame() {
        RacingGame racingGame = createRacingGame();
        playRace(racingGame);
    }

    private void playRace(RacingGame racingGame) {
        while (racingGame.canRace()){
            racingGame.race();
            OutputView.printRaceResult(racingGame.findCurrentPosition());
        }
    }

    private RacingGame createRacingGame(){
        RaceCars raceCars = RaceCars.fromNames(InputView.inputCarNames());
        AttemptCount attemptCount = AttemptCount.from(InputView.inputAttemptCount());
        return new RacingGame(raceCars, attemptCount);
    }

}
