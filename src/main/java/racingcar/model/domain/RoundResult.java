package racingcar.model.domain;

import java.util.Map;

public class RoundResult {
    private final Map<String, Integer> carPositions;

    RoundResult(Map<String, Integer> carPositions) {
        this.carPositions = carPositions;
    }

    public static RoundResult from(Cars cars) {
        Map<String, Integer> carPositionsAtName = cars.mapNamesToPositions();
        return new RoundResult(carPositionsAtName);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        carPositions.forEach((name, position) ->
                result.append(name)
                        .append(" : ")
                        .append("-".repeat(position))
                        .append("\n"));
        return result.toString();
    }
}
