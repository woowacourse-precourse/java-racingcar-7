package racingcar;

import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;
import racingcar.io.request.CarsRequest;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.provider.NumberProvider;

import java.util.Arrays;
import java.util.List;

import static racingcar.io.request.CarsRequest.CAR_NAME_SPLIT_DELIMITER;

public class RacingGame {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final NumberProvider numberProvider;

    public RacingGame(InputHandler inputHandler, OutputHandler outputHandler, NumberProvider numberProvider) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.numberProvider = numberProvider;
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
        CarsRequest request = inputHandler.getCarNamesFromUser();
        return generateCarsFrom(request);
    }

    private Cars generateCarsFrom(CarsRequest request) {
        String[] candidateCarNames = request.nameOfCars().split(CAR_NAME_SPLIT_DELIMITER);
        return Cars.from(Arrays.stream(candidateCarNames)
            .map(Car::from)
            .toList());
    }

    private int getTryCountFromUser() {
        outputHandler.showTryCountComment();
        return inputHandler.getTryCountFromUser().tryCount();
    }

    private void executeRaceRoundBy(final int tryCount, final Cars cars) {
        outputHandler.showResultComment();

        for (int i = 0; i < tryCount; i++) {
            List<Car> movedCars = cars.move(numberProvider);
            outputHandler.showCarsPosition(movedCars);
        }
    }

}
