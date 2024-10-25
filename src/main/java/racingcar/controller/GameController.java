package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.io.Input;
import racingcar.view.io.Output;
import racingcar.model.GameModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameController {
    private final GameModel gameModel;
    private final Input input;
    private final Output output;

    public GameController() {
        this.gameModel = new GameModel();
        this.input = new Input();
        this.output = new Output();
    }

    public void runFullGame() {
        //입력 받기 (나중에 한 메서드로 묶을 것)
        Map<String, Integer> carStepsMap = gameModel.getCarMap();
        int round = gameModel.getRound();

        //로직 실행
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            output.gameResult(startGame(carStepsMap));
        }

        //우승자 출력 받기
        List<String> winnerList = getWinner(carStepsMap);
        output.winner(winnerList);
    }

    private static List<String> getWinner(Map<String, Integer> carMap) {
        List<String> winnerList = new ArrayList<>();
        int top = 0;
        for (String carName : carMap.keySet()) {
            if (carMap.get(carName) > top) {
                top = carMap.get(carName);
            }
        }
        for (String carName : carMap.keySet()) {
            if (carMap.get(carName) == top) {
                winnerList.add(carName);
            }
        }
        return winnerList;
    }



    private static Map<String,Integer> startGame(Map<String,Integer> carMap) {
        for (String key : carMap.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carMap.put(key, carMap.get(key) + 1);
            }
        }
        return carMap;
    }
}
