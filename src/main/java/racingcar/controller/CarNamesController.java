package racingcar.controller;

import java.util.HashMap;
import java.util.List;

public class CarNamesController {
    public static boolean isValid(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.startsWith(" ") | carName.endsWith(" ")) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkConditions (List<String> carNames) {
        for (String carName : carNames) {
            if (!carName.matches("^[A-Za-z0-9ㄱ-힣]{1,5}$")) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDuplication(String carName, HashMap<String, Integer> carPositions) {
        return carPositions.containsKey(carName);
    }

    public static void addCar(String carName, HashMap<String, Integer> carPositions) {
        carPositions.put(carName, 0);
    }
}
