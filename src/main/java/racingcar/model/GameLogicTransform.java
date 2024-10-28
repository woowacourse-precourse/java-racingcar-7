package racingcar.model;

import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validation.ValidateException;

public class GameLogicTransform {
    private static Map<String, Integer> resultMap;

    public GameLogicTransform(Map<String, Integer> resultMap) {
        GameLogicTransform.resultMap = resultMap;
    }

    public void mapByCarName(String carName) {
        String[] carNames = carName.split(",");
        ValidateException validateException = new ValidateException();
        for (String name : carNames) {
            validateException.isCarNameValid(name);
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

