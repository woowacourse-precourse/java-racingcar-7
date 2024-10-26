package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class ProgressCarRace {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVING_FORWARD = 4;


    /**
     * 각 자동차의 전진을 한 차례 시도합니다.
     * 전진 조건은 무작위 값이 일정 수치 이상인 경우입니다.
     */
    void moveForward(Map<String, Integer> stateMap) {
        for (String name: stateMap.keySet()) {
            if(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVING_FORWARD) {
                stateMap.replace(name, stateMap.get(name) + 1);
            }
        }
    }

    /**
     * 현재 각 자동차의 상황(전진 횟수)을 출력합니다.
     */
    void printStates(Map<String, Integer> stateMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : stateMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(" : ");
            stringBuilder.append("-".repeat(Math.max(0, entry.getValue())));
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

}
