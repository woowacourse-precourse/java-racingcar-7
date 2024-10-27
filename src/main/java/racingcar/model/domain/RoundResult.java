package racingcar.model.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RoundResult {

    private final Map<String, Integer> carPositions;

    private RoundResult(Map<String, Integer> carPositions) {
        this.carPositions = new TreeMap<>(carPositions);
    }

    public static RoundResult from(Cars cars) {
        Map<String, Integer> carPositionsAtName = cars.getCarPositionsAtName();
        return new RoundResult(carPositionsAtName);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        carPositions.forEach((name, position) ->
                result.append(name)
                        .append(" : ")
                        .append("-".repeat(position))
                        .append("\n"));
        return result.toString();
    }

    public List<String> getMaxPositionCar() {
        int maxPosition = getMaxPosition();
        return carPositions.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .toList();
    }

    private int getMaxPosition() {
        return carPositions.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
}