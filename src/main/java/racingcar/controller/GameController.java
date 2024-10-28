package racingcar.controller;

import racingcar.service.GameService;
import racingcar.model.CarsManager;
import racingcar.view.OutputView;
import racingcar.dto.RacingResult;
import java.util.List;

public class GameController {
    private final OutputView outputView;
    private final InputController inputController;
    private final GameService gameService;

    public GameController(
            InputController inputController,
            OutputView outputView,
            GameService gameService
    ) {
        this.inputController = inputController;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void run() {
        CarsManager cars = initializeGame();
        playGame(cars);
        showResult(cars);
    }

    private CarsManager initializeGame() {
        return CarsManager.by(inputController.readCarNames());
    }

    private void playGame(CarsManager cars) {
        int trials = inputController.readTrialsCount();
        outputView.printResult();

        for (int round = 0; round < trials; round++) {
            executeOneRound(cars);
        }
    }

    private void executeOneRound(CarsManager cars) {
        gameService.moveAllCarsOnce(cars);
        List<RacingResult> results = gameService.convertToRacingResults(cars);
        outputView.printRacing(results);
    }

    private void showResult(CarsManager cars) {
        outputView.printWinners(cars.getWinners());
    }
}