package racingcar.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinnerService {

    public List<String> judgeWinner(Map<String, Integer> racingCar) {
        Integer maxValue = Collections.max(racingCar.values());
        List<String> winners = new LinkedList<>();

        for (Entry<String, Integer> entry : racingCar.entrySet()) {
            String carName = entry.getKey();
            Integer go = entry.getValue();

            if(go.equals(maxValue)) {
                winners.add(carName);
            }
        }

        return winners;
    }
}
