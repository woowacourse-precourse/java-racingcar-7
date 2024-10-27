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
        int winStandardNumber = viewInput.receiverNumberOfWin();

        RacingGame racingGame = new RacingGame(carNames);
        for(int i = 0 ; i < winStandardNumber ; i++){
            racingGame.playOneTurn();
            ViewOutput.printResult(racingGame.getCarNames());
        }
        ViewOutput.printWinners(racingGame.getWinnerNames());

    }

}
