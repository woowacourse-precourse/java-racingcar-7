package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MovementRecord {

    private final List<Map<String, Integer>> roundRecords = new ArrayList<>();

    public void recordRound(final Cars cars) {
        roundRecords.add(new LinkedHashMap<>(cars.getPositions()));
    }

    public List<Map<String, Integer>> getRounds() {
        return roundRecords;
    }

}
