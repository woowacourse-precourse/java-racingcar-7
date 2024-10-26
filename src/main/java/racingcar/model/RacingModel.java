package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class RacingModel {

    public LinkedHashMap<String, Integer> moveCars(LinkedHashMap<String, Integer> cars) {
        for (Entry<String, Integer> car : cars.entrySet()) {
            if (canMove()) {
                cars.put(car.getKey(), car.getValue() + 1);
            }
        }
        return cars;
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
