package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.GameStatistics;
import racingcar.service.GameService;
import racingcar.util.GameConstants;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class GameController {
    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.gameService = new GameService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            outputView.printGameStart();
            Cars cars = inputView.readCars();
            int attempts = inputView.readAttempts();

            playGame(cars, attempts);
            showResults(cars);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private void playGame(Cars cars, int attempts) {
        outputView.printGameProgress();

        for (int i = 0; i < attempts; i++) {
            outputView.printRoundStart(i + 1);
            gameService.playRound(cars);
            showRoundStatus(cars);
            addDelay();
        }
    }

    private void showRoundStatus(Cars cars) {
        outputView.printRoundResult(cars.getCars());
        outputView.printProgressBar(cars.getProgressBar());
        outputView.printCurrentRankings(cars.getRankings());
    }

    private void showResults(Cars cars) {
        GameStatistics statistics = cars.getStatistics();
        outputView.printGameStatistics(statistics);
        outputView.printWinners(cars.getWinners());
        outputView.printFinalRankings(cars.getRankings());
    }

    private void addDelay() {
        try {
            Thread.sleep(GameConstants.DELAY_MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
