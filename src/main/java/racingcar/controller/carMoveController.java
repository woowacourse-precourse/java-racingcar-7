package racingcar.controller;

import static racingcar.RacingCarConstants.MOVING_FORWARD;
import static racingcar.RacingCarConstants.STOP;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class carMoveController {

    public static void moveController(String[] cars, Map<String, String> carMoveMap) {
        int randomNum;
        for (String car: cars) {
            randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= MOVING_FORWARD) {
                carMoveMap.put(car, carMoveMap.get(car) + '-');
            } else if (randomNum <= STOP) {
                continue;
            }
        }
    }
}
