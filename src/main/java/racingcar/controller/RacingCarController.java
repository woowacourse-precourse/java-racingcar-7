package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        Cars cars = makeCars(scanCarNames());
        int tryCount = scanTryCount();
        raceCars(cars, tryCount);
        printWinner(cars);
    }

    private List<String> scanCarNames(){
        outputView.printScanCarsMessage();
        return inputView.scanCarNames();
    }

    private Cars makeCars(List<String> carNames) {
        return new Cars(carNames);
    }

    private int scanTryCount(){
        outputView.printTryOutCountMessage();
        return inputView.scanTryCount();
    }

    private void raceCars(Cars cars, int tryCount) {
        outputView.printMoveResultMessage();
        Race race = new Race();

        for (int i = 0; i < tryCount; i++) {
            Cars racingCars = race.raceCars(cars);
            outputView.printMovedCars(racingCars);
        }
    }

    private void printWinner(Cars cars) {
        Winner winner = new Winner();
        outputView.printWinner(winner.findWinner(cars));
    }
}
