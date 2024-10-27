package racingcar;

import java.util.*;

public class CarRace {
    //1. 시작 위치 0으로 설정
    Map<String, Integer> initializeCarPositions(List<String> carNames) {
        Map<String, Integer> carPositions = new HashMap<>();
        for (String carName : carNames) {
            carPositions.put(carName, 0);
        }
        return carPositions;
    }
}
