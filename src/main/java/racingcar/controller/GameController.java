package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;


public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private NumberGenerator numberGenerator;

    public GameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void startGame() {
        enterInputs();
    }

    private void enterInputs() {
        OutputView.printCarsInputCommand();

        List<Car> carList = CarsFactory.makeCarList(InputView.enterCarNames());

        Cars cars = new Cars(carList);

        OutputView.printGameCountsCommand();
        GameCounts gameCounts = new GameCounts(InputView.enterCounts());

        progressGame(cars, gameCounts);
    }

    private void progressGame(Cars cars, GameCounts gameCounts) {
        OutputView.printRacingProcessCommand();

        for (int count = 0; count < gameCounts.getGameCounts(); count++) {
            cars.race(numberGenerator);
            outputView.printCarsState(cars);
        }
        showWinner(cars);
    }

    private static void showWinner(Cars cars) {
        String result = cars.findWinnerNames();
        OutputView.printRacingWinner(result);
    }
}
