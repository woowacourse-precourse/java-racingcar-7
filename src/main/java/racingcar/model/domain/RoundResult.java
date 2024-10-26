package racingcar.model.domain;

import java.util.Map;
import java.util.TreeMap;

public class RoundResult {

    private final Map<String, Integer> carPositions;

    public RoundResult(Map<String, Integer> carPositions) {
        this.carPositions = new TreeMap<>(carPositions);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        carPositions.forEach((name, position) -> {
            result.append(name)
                    .append(" : ")
                    .append("-".repeat(position))
                    .append("\n");
        });
        return result.toString();
    }
}