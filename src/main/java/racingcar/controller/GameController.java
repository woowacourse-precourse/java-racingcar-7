package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameCounts;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameController {

    public void enterInputs(){
        OutputView.printStartCommand();
        Cars cars=new Cars(InputView.enterCarNames());

        OutputView.printRacingCounts();
        GameCounts gameCounts=new GameCounts(InputView.enterCounts());

        //processGame(cars,gameCounts);
    }
}
