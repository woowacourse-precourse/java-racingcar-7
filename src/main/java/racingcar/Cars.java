package racingcar;

import java.util.List;

public class Cars {

    private final List<String> cars;
    static final int INCLUDE_LAST_EMPTY_STRING = -1;
    static final int DEFAULT_MOVE_POINT = 0;

    public Cars(String carNameString) {
//        Map<String, Integer> cars = new LinkedHashMap<>();

        List<String> carNameArray = List.of(carNameString.split(",", INCLUDE_LAST_EMPTY_STRING));
//        for (String carName : carNameArray) {
//            cars.put(carName, DEFAULT_MOVE_POINT);
//        }

        validateWrongValue(carNameArray);
        validateNameLength(carNameArray);

        this.cars = carNameArray;
    }

    public List<String> getCars() {
        return cars;
    }

    private void validateNameLength(List<String> cars) {
        for (String carName : cars) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
            }
        }
    }

    private void validateWrongValue(List<String> cars) {
        if (cars.contains("")) {
            throw new IllegalArgumentException("잘못된 값이 입력됐습니다.");
        }
    }
}
