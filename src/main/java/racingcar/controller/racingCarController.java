package racingcar.controller;

import static racingcar.RacingCarConstants.MOVING_FORWARD;
import static racingcar.RacingCarConstants.STOP;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class racingCarController {

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

    public static ArrayList<String> findWinners(Map<String, String> carMoveMap) {
        ArrayList<String> winners = new ArrayList<>();
        int winnerPosition = 0;

        for (Entry<String, String> items : carMoveMap.entrySet()) {
            int position = items.getValue().length();

            if (position > winnerPosition) {
                winnerPosition = position;
                winners.clear();
                winners.add(items.getKey());
            } else if (position == winnerPosition) {
                winners.add(items.getKey());
            } else {
                continue;
            }
        }

        return winners;
    }
}
