package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.net.Inet4Address;
import java.util.*;

public class CarRace {
    //1. 시작 위치 0으로 설정
    public Map<String, Integer> initializeCarPositions(List<String> carNames) {
        Map<String, Integer> carPositions = new HashMap<>();
        for (String carName : carNames) {
            carPositions.put(carName, 0);
        }
        return carPositions;
    }

    //2. 게임 실행: 랜덤으로 4이상일 경우 자동차 이동
    public void moveCars(Map<String, Integer> carPositions) {
        for (String carName : carPositions.keySet()){
            int move = Randoms.pickNumberInRange(0,9);
            if (move >= 4){
                carPositions.put(carName, carPositions.get(carName)+1);
            }
        }

        for (Map.Entry<String, Integer> entry : carPositions.entrySet()){
            String carName = entry.getKey();
            Integer position = entry.getValue();
            System.out.println(carName + ": " + "-".repeat(position));
        }
    }
}
