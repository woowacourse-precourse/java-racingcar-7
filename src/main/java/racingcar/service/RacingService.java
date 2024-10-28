package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.exception.InputExceptionHandler;

public class RacingService {

    public int parseAttemptCount(String inputAttemptCount) {
        InputExceptionHandler.validateEmpty(inputAttemptCount);
        InputExceptionHandler.validateAttemptCount(inputAttemptCount);

        return Integer.parseInt(inputAttemptCount);
    }

    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public List<String> racingWinner(HashMap<String, Integer> cars) {
        List<String> winner = new ArrayList<>();

        int maxValue = 0;
        for (String name : cars.keySet()) {
            if (cars.get(name) > maxValue) {
                maxValue = cars.get(name);
            }
        }

        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            if (entry.getValue() == maxValue) {
                winner.add(entry.getKey());
            }
        }

        return winner;
    }
}
