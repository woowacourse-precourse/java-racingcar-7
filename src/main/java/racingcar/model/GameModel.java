package racingcar.model;

import java.util.*;

public class GameModel {
    public Map<String, Integer> getCarMap(String[] carNames) {
        Map<String, Integer> carMap = new LinkedHashMap<>();

        trimCarNames(carNames);

        List<String> validCarNames = Arrays.stream(carNames)
                                            .filter(name -> !name.isEmpty())
                                            .toList();

        validateCarNames(validCarNames);

        for (String carName : validCarNames) {
            carMap.put(carName, 0);
        }

        return carMap;
    }

    private static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        if (carNames.size() < 2) throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
    }

    private void trimCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].strip();
        }
    }

    public int getRound(String gameRound) {
        getNumRound(gameRound);
        return Integer.parseInt(gameRound);
    }

    private void getNumRound(String gameRound) {
        try {
            int numRound = Integer.parseInt(gameRound);
            if (numRound < 0) throw new IllegalArgumentException("음수는 입력이 불가능합니다.");
            System.out.println();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 이외의 값은 입력이 불가능합니다.");
        }
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
