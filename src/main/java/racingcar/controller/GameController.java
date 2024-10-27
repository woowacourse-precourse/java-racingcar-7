package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winner;
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
        startGame(cars);

        Winner winner = winnerPlayers(cars);
        endGame(winner);
    }

    private void endGame(Winner winner) {
        String info = winner.winnerInfo();
        outputView.printFinalWinners(info);
    }

    private Winner winnerPlayers(Cars cars) {
        Car manyMoveCar = cars.getFurthestCar();
        return new Winner(cars, manyMoveCar);
    }

    private Cars initCars() {
        String inputCarNames = inputView.inputCarNames();
        return new Cars(inputCarNames);
    }

    private void startGame(Cars cars) {
        int totalRoundCount = inputView.inputTryCount();

        outputView.printRunResult();
        for (int round = 0; round < totalRoundCount; round++) {
            cars.executeRound();
            outputView.printRoundResult(cars.getCarStates());
        }
    }
}
