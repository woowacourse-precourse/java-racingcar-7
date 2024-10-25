package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameCounts;
import racingcar.domain.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameController {

    private InputView inputView;
    private OutputView outputView;
    private NumberGenerator numberGenerator;

    public GameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView=inputView;
        this.outputView=outputView;
        this.numberGenerator=numberGenerator;
    }

    public void startGame(){
        enterInputs();
    }

    private void enterInputs() {
        OutputView.printStartCommand();
        Cars cars=new Cars(InputView.enterCarNames());

        OutputView.printRacingCounts();
        GameCounts gameCounts=new GameCounts(InputView.enterCounts());

        progressGame(cars,gameCounts);
    }

    private void progressGame(Cars cars, GameCounts gameCounts) {
        OutputView.printRacingProcess();

        for (int count=0;count<gameCounts.getGameCounts();count++){
            cars.race(numberGenerator);
            OutputView.printState(cars);
        }
        printWinner(cars);
    }

    private static void printWinner(Cars cars) {
        String result=cars.findWinners();
        OutputView.printRacingWinner(result);
    }


}
