package racingcar.executor.decider.winner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WinnerListDeciderImpl implements WinnerListDecider {
    @Override
    public List<String> findWinners(Map<String, Integer> history) {
        int maxDistance = history.values().stream()
                .max(Integer::compare)
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : history.entrySet())
            if (entry.getValue() == maxDistance)
                winners.add(entry.getKey());

        return winners;
    }
}
