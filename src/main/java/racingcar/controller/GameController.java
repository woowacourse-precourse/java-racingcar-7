package racingcar.controller;

import java.util.Map;
import racingcar.domain.MoveCount;
import racingcar.service.GameService;
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
        while (moveCount.canMove()) {
            gameService.moveCarsRandomly();
            moveCount.decreaseCount();
            Map<String, Integer> gameDataMap = gameService.getGameData();
            outputView.showCurrentStatus(gameDataMap);
        }
    }
}
