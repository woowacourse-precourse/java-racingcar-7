package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.service.GameRunner;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;
    private final GameRunner gameRunner;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService, GameRunner gameRunner) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
        this.gameRunner = gameRunner;
    }

    public void initializeGame() {
        Set<String> carNames = splitCarNames();
        int attemptCount = parseAttemptCount();
        startGame(carNames, attemptCount);
    }

    public Set<String> splitCarNames() {
        String carNameList = inputView.getCarName();
        return racingCarService.splitCarName(carNameList);
    }

    public int parseAttemptCount() {
        String attemptCount = inputView.getAttemptCount();
        return racingCarService.parseAttemptCount(attemptCount);
    }

    public void startGame(Set<String> carNames, int attemptCount) {
        List<String> roundResults = new ArrayList<>();
        Map<String, Integer> carState = gameRunner.runGame(carNames, attemptCount, roundResults);

        roundResults.forEach(outputView::showRoundResult);

        showResult(carState);
    }

    public void showResult(Map<String, Integer> carState) {
        String winners = gameRunner.getWinner(carState);
        outputView.showWinners(winners);
    }
}
