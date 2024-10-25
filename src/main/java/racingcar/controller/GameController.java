package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
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
            gameView.output.gameResult(startGame(carStepsMap));
        }

        //우승자 출력 받기
        List<String> winnerList = gameModel.getWinner(carStepsMap);
        gameView.output.winner(winnerList);
    }

    private Map<String,Integer> startGame(Map<String,Integer> carMap) {
        for (String key : carMap.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carMap.put(key, carMap.get(key) + 1);
            }
        }
        return carMap;
    }


}
