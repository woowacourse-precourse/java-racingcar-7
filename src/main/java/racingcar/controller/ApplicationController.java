package racingcar.controller;

import java.util.List;
import racingcar.model.RacingGame;
import racingcar.view.ViewInput;
import racingcar.view.ViewOutput;

public class ApplicationController {

    private final ViewInput viewInput;

    public ApplicationController(ViewInput viewInput) {
        this.viewInput = viewInput;
    }


    public void run(){
        List<String> carNames = viewInput.receiveCarNames();
        int attempts = viewInput.receiveRaceAttempts();

        RacingGame racingGame = new RacingGame(carNames);
        for(int i = 0 ; i < attempts ; i++){
            racingGame.playOneTurn();
            ViewOutput.printResult(racingGame.getCars());
        }
        ViewOutput.printWinners(racingGame.getWinnerNames());

    }

}
