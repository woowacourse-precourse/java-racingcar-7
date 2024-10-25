package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RacingCarCollection {
    private Map<String, Integer> carList;
    private Integer tryCount;
    private final int MAX_LENGTH = 5;


    public RacingCarCollection(String carString, String readTryCount) {
        carList = new HashMap<>();
        String[] cars = carString.split(",");
        validate(cars);
        arrToMap(cars);
        tryCount = Integer.parseInt(readTryCount);
    }

    private void arrToMap(String[] cars) {
        for (String s : cars){
            carList.put(s, 0);
        }
    }


    private void validate(String[] cars) {
        validateCarNameLength(cars);
        validateDuplicateName(cars);
        validateNotAllowedCharacter(cars);
    }

    private void validateNotAllowedCharacter(String[] cars) {
        for (String car : cars) {
            if (!car.matches("[a-zA-Z]+")) throw new IllegalArgumentException("[ERROR] : 허용되지 않은 문자가 포함되어있습니다.");
        }
    }

    private void validateDuplicateName(String[] cars) {
        int carsLength = cars.length;
        HashSet<String> duplicateNameSet = new HashSet<>();
        for (String car : cars) {
            duplicateNameSet.add(car);
        }
        if (carsLength != duplicateNameSet.size()) throw new IllegalArgumentException("[ERROR] : 자동차의 이름이 중복되어서는 안됩니다.");
    }

    private void validateCarNameLength(String[] cars) {
        for (String car : cars) {
            if (car.length() > MAX_LENGTH || car.isEmpty()) throw new IllegalArgumentException("[ERROR] : 자동차 이름은 5자 이하이거나 비어서는 안됩니다.");
        }
    }

    public Map<String, Integer> getCarList() {
        return carList;
    }

    public Integer getTryCount() {
        return tryCount;
    }
}
