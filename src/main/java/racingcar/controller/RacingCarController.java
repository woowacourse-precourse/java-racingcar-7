package racingcar.controller;

import java.util.Map;
import java.util.Set;
import racingcar.model.Game;
import racingcar.model.GameResult;
import racingcar.service.GameRunner;
import racingcar.service.GameSetup;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameSetup racingCarService;
    private final GameRunner gameRunner;

    public RacingCarController(InputView inputView, OutputView outputView, GameSetup racingCarService, GameRunner gameRunner) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
        this.gameRunner = gameRunner;
    }

    public void initializeGame() {
        Set<String> carNames = splitCarNames();
        int attemptCount = parseAttemptCount();

        Game game = new Game(carNames, attemptCount);

        startGame(game);
    }

    public Set<String> splitCarNames() {
        String carNameList = inputView.getCarName();
        return racingCarService.splitCarName(carNameList);
    }

    public int parseAttemptCount() {
        String attemptCount = inputView.getAttemptCount();
        return racingCarService.parseAttemptCount(attemptCount);
    }

    public void startGame(Game game) {
        GameResult gameResult = gameRunner.runGame(game.getCarNames(), game.getAttemptCount());
        outputView.showRoundResult(gameResult.getAllRoundResults());
        showResult(gameResult.getFinalCarState());
    }

    public void showResult(Map<String, Integer> carState) {
        String winners = gameRunner.getWinner(carState);
        outputView.showWinners(winners);
    }
}
