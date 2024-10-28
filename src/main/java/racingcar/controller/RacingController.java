package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;

public class RacingController {

    public static void racing(List<String> carNames, HashMap<String, Integer> carPositions) {
        for (String carName : carNames) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                carPositions.put(carName, carPositions.get(carName)+1);
            }
        }
    }
}
