package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingGame(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        outputHandler.showGameStartComment();
        String carNamesFromUser = inputHandler.getCarNamesFromUser();
        outputHandler.showTryCountComment();
        int tryCount = inputHandler.getTryCountFromUser().tryCount();
        String[] split = carNamesFromUser.split(",");
        Cars cars = Cars.from(Arrays.stream(split)
            .map(Car::from)
            .toList());

        outputHandler.showResultComment();
        for (int i = 0; i < tryCount; i++) {
            List<Car> movedCars = cars.move();
            outputHandler.showCarsPosition(movedCars);
        }

        List<Car> winnerCars = cars.getWinnerCars();
        outputHandler.showWinners(winnerCars);

    }

}
