package racingcar.Domain;

import java.util.HashMap;
import java.util.List;

public class CarManager {
    HashMap<String, Integer> carList = new HashMap();

    public CarManager(List<String> carNames) {
        for (String carName : carNames) {
            carList.put(carName, 0);
        }
    }

    public void moveForward(String carName, Integer randomNumber) {
        if (randomNumber >= 4) {
            Integer currentPosition = carList.get(carName);
            carList.put(carName, currentPosition + 1);
        }
    }

    public HashMap<String, Integer> exportCarList() {
        return carList;
    }
}
