package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class RacingGame {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingGame(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        Cars cars = getCarsFromUser();
        int tryCount = getTryCountFromUser();

        executeRaceRoundBy(tryCount, cars);

        List<Car> winnerCars = cars.getWinnerCars();
        outputHandler.showWinners(winnerCars);
    }

    private Cars getCarsFromUser() {
        outputHandler.showGameStartComment();
        return inputHandler.getCarNamesFromUser();
    }

    private int getTryCountFromUser() {
        outputHandler.showTryCountComment();
        return inputHandler.getTryCountFromUser().tryCount();
    }

    private void executeRaceRoundBy(final int tryCount, final Cars cars) {
        outputHandler.showResultComment();

        for (int i = 0; i < tryCount; i++) {
            List<Car> movedCars = cars.move();
            outputHandler.showCarsPosition(movedCars);
        }
    }

}
