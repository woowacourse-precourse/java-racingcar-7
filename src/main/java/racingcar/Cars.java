package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cars {

    private Map<String, Integer> cars;

    public Cars(String str) {
        Map<String, Integer> cars = new LinkedHashMap<>();
        String[] strArr = str.split(",", -1);

        for (String s : strArr) {
            cars.put(s, 0);
        }

        validateWrongValue(cars);
        validateNameLength(cars);

        this.cars = cars;
    }

    public Map<String, Integer> getCars() {
        return cars;
    }

    private void validateNameLength(Map<String, Integer> cars) {
        for (String carName : cars.keySet()) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
            }
        }
    }

    private void validateWrongValue(Map<String, Integer> cars) {
        if (cars.containsKey("")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
