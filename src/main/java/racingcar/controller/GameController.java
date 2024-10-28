package racingcar.controller;

import java.util.List;
import racingcar.domain.game.GameResult;
import racingcar.dto.request.GameStartRequest;
import racingcar.dto.response.Winners;
import racingcar.exception.game.GameException;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(
            GameService gameService,
            InputView inputView,
            OutputView outputView) {
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            GameStartRequest request = createRequest();
            executeGame(request);
        } catch (GameException e) {
            System.out.println(e.getMessage());
        }
    }

    private GameStartRequest createRequest() {
        List<String> names = inputView.readNames();
        int rounds = inputView.readRounds();
        return new GameStartRequest(names, rounds);
    }

    private void executeGame(GameStartRequest request) {
        gameService.initialize(request);
        playRounds();
        announceWinners();
    }

    private void playRounds() {
        outputView.displayRunResultText();
        while (gameService.hasNextRound()) {
            GameResult result = gameService.playRound();
            outputView.displayResult(result);
        }
    }

    private void announceWinners() {
        Winners winners = gameService.getWinners();
        outputView.displayWinners(winners);
    }
}
