package racingcar.model;

import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;

public class GameLogicTransform {
    private static Map<String, Integer> resultMap;

    public GameLogicTransform(Map<String, Integer> resultMap) {
        GameLogicTransform.resultMap = resultMap;
    }

    public void mapByCarName(String carName) {
        String[] carNames = carName.split(",");

        for (String name : carNames) {
            resultMap.put(name.trim(), 0);
        }
    }

    public void updateMapByResult() {
        for (String key : resultMap.keySet()) {
            if (isNumberMoreFour()) {
                resultMap.put(key, resultMap.get(key) + 1);
            }
        }
    }

    private boolean isNumberMoreFour() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}

