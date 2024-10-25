package racingcar.controller;

import racingcar.view.GameView;
import racingcar.model.GameModel;

import java.util.List;
import java.util.Map;

public class GameController {
    private final GameModel gameModel;
    private final GameView gameView;

    public GameController() {
        this.gameModel = new GameModel();
        this.gameView = new GameView();
    }

    public void runFullGame() {
        //입력 받기 (나중에 한 메서드로 묶을 것)
        Map<String, Integer> carStepsMap = gameModel.getCarMap(gameView.input.carName().split(","));
        int round = gameModel.getRound(gameView.input.gameRound());

        //로직 실행
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            gameView.output.gameResult(gameModel.startGame(carStepsMap));
        }

        //우승자 출력 받기
        List<String> winnerList = gameModel.getWinner(carStepsMap);
        gameView.output.winner(winnerList);
    }


}
