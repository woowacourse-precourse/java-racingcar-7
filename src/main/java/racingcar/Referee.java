package racingcar;

import java.util.List;
import java.util.Map;

public class Referee {

    public List<String> judgmentWinner(Map<String, Integer> carsDecision) {
        return carsDecision.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxPosition(carsDecision))
                .map(Map.Entry::getKey)
                .toList();
    }

    private Integer maxPosition(Map<String, Integer> carsDecision) {
        return carsDecision.values()
                .stream()
                .max(Integer::compareTo)
                .get();
    }
}
