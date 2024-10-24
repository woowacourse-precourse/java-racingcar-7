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
        Cars cars = makeCars();
        raceCars(cars);
        printWinner(cars);
    }

    private Cars makeCars() {
        String[] carNames = inputView.scanCarNames();
        return new Cars(carNames);
    }

    private void raceCars(Cars cars) {
        int tryCount = inputView.scanTryCount();
        outputView.printMoveResultMessage();

        for (int i = 0; i < tryCount; i++) {
            runRaceIteration(cars);
        }
    }

    private void runRaceIteration(Cars cars) {
        Race race = new Race();
        Cars racingCars = race.startRace(cars);
        outputView.printMovedCars(racingCars);
        System.out.println();
    }

    private void printWinner(Cars cars) {
        Winner winner = new Winner();
        List<String> winners = winner.getWinner(cars);
        outputView.printWinner(winners);
    }
}
