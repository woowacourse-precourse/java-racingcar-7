package racingcar.controller;

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
            if (!carName.matches("^[A-Za-z0-9가-힣]{1,5}$]")) {
                return false;
            }
        }
        return true;
    }
}
