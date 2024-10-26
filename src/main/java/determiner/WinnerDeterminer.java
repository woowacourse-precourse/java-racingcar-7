package determiner;

import java.util.*;

public class WinnerDeterminer {

    public List<String> run(Map<String, Integer> raceResult) throws IllegalArgumentException {
        if (raceResult.isEmpty()) {
            throw new IllegalArgumentException("empty race result");
        }
        List<String> winners = new ArrayList<>();
        Integer maxValue = Collections.max(raceResult.values());

        for (String car : raceResult.keySet()) {
            if (raceResult.get(car) == maxValue) {
                winners.add(car);
            }
        }

        return winners;
    }
}
