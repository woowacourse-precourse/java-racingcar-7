package racingcar.Domain;

import java.util.HashMap;
import java.util.List;

public class CarInfo {
    HashMap<String, Integer> carList = new HashMap();

    public CarInfo(List<String> carNames) {
        for (String carName : carNames) {
            carList.put(carName, 0);
        }
    }

    public void moveForward(String carName, Integer randomNumber) {
        if (randomNumber >= 4) {
            int currentPosition = carList.get(carName);
            carList.put(carName, currentPosition + 1);
        }
    }
}
