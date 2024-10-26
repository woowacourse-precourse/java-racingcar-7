package racingcar.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cars {
    private Map<String, Integer> cars;

    public Cars(Map<String, Integer> cars) {
        carNameValidate(cars);
        this.cars = cars;
    }

    private void carNameValidate(Map<String, Integer> cars) {

        Iterator<String> keys = cars.keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();
            lengthValidate(key);
        }
    }

    private void lengthValidate(String carName) {

        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 차 이름은 5자 이하여야 합니다");
        }
    }
}
