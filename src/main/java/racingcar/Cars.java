package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Cars {

    private Map<String, Integer> carNames;

    public Cars(String str) {
        Map<String, Integer> carNames = new LinkedHashMap<>();
        String[] strArr = str.split(",", -1);

        for (String s : strArr) {
            carNames.put(s, 0);
        }

        validateWrongValue(carNames);
        validateNameLength(carNames);

        this.carNames = carNames;
    }

    public Set<String> getCarNames() {
        return carNames.keySet();
    }

    private void validateNameLength(Map<String, Integer> carNames) {
        for (String carName : carNames.keySet()) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
            }
        }
    }

    private void validateWrongValue(Map<String, Integer> carNames) {
        if (carNames.containsKey("")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
