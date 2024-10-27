package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class CarRace {
    private Map<String, Integer> carPositions;

    //1. 시작 위치 0으로 설정
    public void initializeCarPositions(List<String> carNames) {
        carPositions = new HashMap<>();
        for (String carName : carNames) {
            carPositions.put(carName, 0);
        }
    }

    //2. 게임 실행: 랜덤으로 4이상일 경우 자동차 이동
    public void moveCars() {
        for (String carName : carPositions.keySet()) {
            int move = Randoms.pickNumberInRange(0, 9);
            if (move >= 4) {
                carPositions.put(carName, carPositions.get(carName) + 1);
            }
        }
    }

    //3. 현재의 차 위치 출력
    public void printCarPositions() {
        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            String carName = entry.getKey();
            Integer position = entry.getValue();
            System.out.println(carName + ": " + "-".repeat(position));
        }
        System.out.println();
    }

    //4. 시도 횟수만큼 반복 실행
    public void attemptRace(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            System.out.println(i + 1 + "번째 시도");
            moveCars();
            printCarPositions();
        }
    }
}