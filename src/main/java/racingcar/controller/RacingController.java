package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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

    public static List<String> findWinners(List<String> carNames, HashMap<String, Integer> carPositions) {
        List<String> winners = new ArrayList<>();
        int winnerPosition = Collections.max(carPositions.values());

        for (String carName : carNames) {
            if (carPositions.get(carName) == winnerPosition) {
                winners.add(carName);
            }
        }
        return winners;
    }
}
