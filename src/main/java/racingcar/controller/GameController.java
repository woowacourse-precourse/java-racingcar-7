package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameCounts;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameController {

    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView=inputView;
        this.outputView=outputView;
    }

    public void startGame(){
        enterInputs();
    }

    private static void enterInputs() {
        OutputView.printStartCommand();
        Cars cars=new Cars(InputView.enterCarNames());

        OutputView.printRacingCounts();
        GameCounts gameCounts=new GameCounts(InputView.enterCounts());

        progressGame(cars,gameCounts);
    }

    private static void progressGame(Cars cars, GameCounts gameCounts) {
        OutputView.printRacingProcess();

        for (int count=0;count<gameCounts.getGameCounts();count++){
            cars.race();
            cars.printState();
        }
        printWinner(cars);
    }

    private static void printWinner(Cars cars) {
        String result=cars.findWinners();
        OutputView.printRacingWinner(result);
    }


}
