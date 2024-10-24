package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cars {

    private final Map<String, Integer> cars;
    static final int INCLUDE_LAST_EMPTY_STRING = -1;
    static final int DEFAULT_MOVE_POINT = 0;

    public Cars(String carNameString) {
        Map<String, Integer> cars = new LinkedHashMap<>();

        String[] carNameArray = carNameString.split(",", INCLUDE_LAST_EMPTY_STRING);
        for (String carName : carNameArray) {
            cars.put(carName, DEFAULT_MOVE_POINT);
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
