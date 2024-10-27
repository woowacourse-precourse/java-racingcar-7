package racingcar.controller;

import racingcar.view.GameView;
import racingcar.model.GameModel;

import java.util.List;

public class GameController {
    private final GameModel gameModel;
    private final GameView gameView;

    public GameController() {
        this.gameModel = new GameModel();
        this.gameView = new GameView();
    }

    public void runFullGame() {
        String[] carNames = gameView.input.carName().split(",");
        int round = gameModel.getRound(gameView.input.gameRound());
        gameModel.setCarMap(carNames);

        System.out.println("실행 결과");

        for (int i = 0; i < round; i++) {
            gameModel.moveCars();
            gameView.output.gameResult(gameModel.getCarMap());
        }

        List<String> winnerList = gameModel.getWinner(gameModel.getCarMap());
        gameView.output.winner(winnerList);
    }


}
