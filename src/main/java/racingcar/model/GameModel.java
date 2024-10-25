package racingcar.model;

import java.util.*;

public class GameModel {
    public Map<String, Integer> getCarMap(String[] carNames) {
        Map<String, Integer> carMap = new LinkedHashMap<>();
        for (String carName : carNames) {
            if (carName.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            carMap.put(carName, 0);
        }
        return carMap;
    }

    public int getRound(String gameRound) {
        int numRound;
        try {
            numRound = Integer.parseInt(gameRound);
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
