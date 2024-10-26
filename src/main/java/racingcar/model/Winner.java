package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Winner {

    public List<String> informWho(HashMap<String, Integer> raceStatus) {
        List<String> winners = new ArrayList<>();
        int maxValue = raceStatus.values().stream().mapToInt(Integer::intValue).max()
            .orElse(Integer.MIN_VALUE);
        for (String key : raceStatus.keySet()) {
            if (maxValue == raceStatus.get(key)) {
                winners.add(key);
            }
        }
        return winners;
    }
}
