package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cars {

    public static Map<String, Integer> createNameList(String str) {
        Map<String, Integer> carNames = new LinkedHashMap<>();
        String[] strArr = str.split(",", -1);

        for (String s : strArr) {
            carNames.put(s, 0);
        }

        validateWrongValue(carNames);
        validateNameLength(carNames);

        return carNames;
    }

    private static void validateNameLength(Map<String, Integer> carNames) {
        for (String carName : carNames.keySet()) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
            }
        }
    }

    private static void validateWrongValue(Map<String, Integer> carNames) {
        if (carNames.keySet().contains("")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
