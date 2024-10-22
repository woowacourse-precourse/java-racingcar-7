package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameCounts;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameController {

    public static void enterInputs(){
        OutputView.printStartCommand();
        Cars cars=new Cars(InputView.enterCarNames());

        OutputView.printRacingCounts();
        GameCounts gameCounts=new GameCounts(InputView.enterCounts());

        processGame(cars,gameCounts);
    }

    private static void processGame(Cars cars, GameCounts gameCounts) {
        for (int count=0;count<gameCounts.getGameCounts();count++){
            cars.race();
        }

    }
}
