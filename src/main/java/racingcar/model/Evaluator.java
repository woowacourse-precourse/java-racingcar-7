package racingcar.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Evaluator {
    protected List<String> searchWinners(Cars cars) {
        Map<String, Integer> roundStatus = cars.getRoundStatus();
        List<String> winners = new ArrayList<>();

        Collection<Integer> roundStatusPosition = roundStatus.values();
        int maxPosition = Collections.max(roundStatusPosition);

        for (Entry<String, Integer> entry : roundStatus.entrySet()) {
            int position = entry.getValue();

            if (position >= maxPosition) {
                String winner = entry.getKey();
                winners.add(winner);
            }
        }
        return winners;
    }
}