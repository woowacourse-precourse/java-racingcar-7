package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.model.Car;
import racingcar.model.Cars;

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
        String namesOfCars = getNamesOfCarsFromUser();
        Cars cars = generateCarsFrom(namesOfCars);
        
        int tryCount = getTryCountFromUser();

        executeRaceRoundBy(tryCount, cars);

        List<Car> winnerCars = cars.getWinnerCars();
        outputHandler.showWinners(winnerCars);
    }

    private void executeRaceRoundBy(int tryCount, Cars cars) {
        outputHandler.showResultComment();
        
        for (int i = 0; i < tryCount; i++) {
            List<Car> movedCars = cars.move();
            outputHandler.showCarsPosition(movedCars);
        }
    }

    private Cars generateCarsFrom(String namesOfCars) {
        String[] split = namesOfCars.split(",");
        return Cars.from(Arrays.stream(split)
            .map(Car::from)
            .toList());
    }

    private String getNamesOfCarsFromUser() {
        outputHandler.showGameStartComment();
        return inputHandler.getCarNamesFromUser();
    }

    private int getTryCountFromUser() {
        outputHandler.showTryCountComment();
        return inputHandler.getTryCountFromUser().tryCount();
    }

}
