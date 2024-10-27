package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameController {

    private static GameData gameData = new GameData();
    private static GameView gameView = new GameView();

    // 게임 초기화, 세팅
    public void gameinit() {
        gameData.setCars(gameView.inputCarName());
        gameData.setCount(gameView.inputGameCount());
    }

    // 게임 시작
    public void gameStart() {
        HashMap<String, Integer> cars;
        int cnt = gameData.getCount();

        for(int i=0; i<cnt; i++) {
            cars = move(gameData.getCars());
            gameData.setCars(cars);
            gameView.printGame(gameData.getCars());
        }
    }

    // 게임 결과
    public void gameResult() {
        HashMap<String, Integer> cars = gameData.getCars();
        List<String> winner = new ArrayList<>();
        int max = -1;
        for(String car : gameData.sortKeys()) {
            max = Math.max(max, cars.get(car));
            if(max == cars.get(car)) {
                max = cars.get(car);
                winner.add(car);
            }
        }

        gameView.printWinner(winner);
    }

    private HashMap<String, Integer> move(HashMap<String, Integer> cars) {
        for(String name: cars.keySet()) {
            int num = Randoms.pickNumberInRange(0, 9);
            if(num >= 4)
                cars.put(name, cars.get(name) + 1);
        }
        return cars;
    }
}
