package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;

    public GameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        Cars cars = initCars();
        executeRounds(cars);
        displayWinners(cars);
    }

    private void displayWinners(Cars cars) {
        Winners winner = determineWinners(cars);
        outputView.printFinalWinners(winner.toString());
    }

    private Winners determineWinners(Cars cars) {
        Car furthestCar = cars.getFurthestCar();
        return new Winners(cars, furthestCar);
    }

    private Cars initCars() {
        String CarNames = inputView.inputCarNames();
        return new Cars(CarNames);
    }

    private void executeRounds(Cars cars) {
        int totalRoundCount = inputView.inputTryCount();

        outputView.printRunResult();
        for (int round = 0; round < totalRoundCount; round++) {
            cars.executeRound();
            outputView.printRoundResult(cars.getCarStates());
        }
    }
}
