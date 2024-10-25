package racingcar.model;

import racingcar.view.io.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameModel {
    public static final Input input = new Input();
    public Map<String, Integer> getCarMap() {
        String[] splitCarName = input.carName().split(",");
        Map<String, Integer> carMap = new HashMap<>();
        for (String carName : splitCarName) {
            if (carName.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            carMap.put(carName, 0);
        }
        return carMap;
    }

    public int getRound() {
        int numRound;
        try {
            numRound = Integer.parseInt(input.gameRounds());
            System.out.println();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 이외의 값은 입력이 불가능합니다.");
        }
        if (numRound < 0) {
            throw new IllegalArgumentException("음수는 입력이 불가능합니다.");
        }
        return numRound;
    }

    public List<String> getWinner(Map<String, Integer> carMap) {
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
}
