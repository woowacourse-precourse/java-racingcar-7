package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingGame racingGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        List<String> carNames = inputView.getCarNames();
        int moveCount = inputView.getMoveCount();
        initializeGame(carNames, moveCount);
        playGame();
        announceWinners();
    }

    private void initializeGame(List<String> carNames, int moveCount) {
        List<Car> cars = Car.createCars(carNames);
        racingGame = new RacingGame(cars, moveCount);
    }

    private void playGame() {
        outputView.printExecutionResult();
        while (racingGame.hasNextRound()) {
            racingGame.playRound();
            outputView.printRoundResult(racingGame.getCars());
        }
    }

    private void announceWinners() {
        List<String> winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }
}