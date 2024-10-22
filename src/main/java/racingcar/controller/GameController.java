package racingcar.controller;

import java.util.List;
import racingcar.domain.MoveCount;
import racingcar.dto.GameResultDto;
import racingcar.service.GameService;
import racingcar.utility.Calculator;
import racingcar.view.OutputView;

public class GameController {
    private final GameService gameService;

    private final OutputView outputView;

    public GameController(GameService gameService, OutputView outputView) {
        this.gameService = gameService;
        this.outputView = outputView;
    }

    public void executeRace(MoveCount moveCount) {
        outputView.showStartMessage();
        GameResultDto gameResultDto = null;
        while (moveCount.canMove()) {
            gameService.moveCarsRandomly();
            moveCount.decreaseCount();
            gameResultDto = gameService.getGameData();
            outputView.showCurrentStatus(gameResultDto);
        }
        if (gameResultDto == null) {
            throw new IllegalArgumentException();
        }
        List<String> winners = Calculator.findWinners(gameResultDto);
        outputView.showWinner(winners);
    }
}
