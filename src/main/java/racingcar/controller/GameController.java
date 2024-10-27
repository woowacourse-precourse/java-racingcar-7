package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private int totalRounds;

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void run() {
        initializeGame();
        playGame();
        displayFinalResult();
    }

    public void initializeGame() {
        List<String> carNames = inputView.getUserInput();
        this.totalRounds = inputView.getUserInputAsInt();

        gameService.initializeGame(carNames);
    }

    private void playGame() {
        for (int i = 0; i < totalRounds; i++) {
            List<Car> roundResults = gameService.gameStart();
            displayRoundResult(roundResults);
        }
    }

    private void displayRoundResult(List<Car> cars) {
        outputView.printRoundResult(cars);
    }

    private void displayFinalResult() {
        List<String> winners = gameService.determineWinners();
        outputView.printFinalWinners(winners);
    }
}