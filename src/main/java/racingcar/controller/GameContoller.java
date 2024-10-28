package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameContoller {

    public static final int INITIAL_SCORE = 0;
    private final Map<String, Integer> playerScoreBoard;
    private final Integer totalTurn;
    private final GameService gameService = new GameService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public GameContoller() {
        List<String> playerNames = inputView.readPlayerNameList();
        playerScoreBoard = gameService.mapPlayerNames(playerNames);
        totalTurn = inputView.readTurnFromInput();
    }

    public void run() {
        for (int curTurn = 0; curTurn < totalTurn; curTurn++) {
            gameService.movePlayersRandomly(playerScoreBoard);
            outputView.printCurResult(playerScoreBoard);
        }
        outputView.printFinalResult(playerScoreBoard);
    }

}
