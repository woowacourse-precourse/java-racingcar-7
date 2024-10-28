package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingSnapshot {

    private static final String POSITION_MARKER = "-";
    private final Map<Car, Integer> results = new LinkedHashMap<>();

    public RacingSnapshot(List<Car> cars) {
        cars.forEach(car -> results.put(car, car.getPosition()));
    }

    public void print() {
        results.forEach((car, position) ->
                System.out.println(car.getName() + " : " + POSITION_MARKER.repeat(position)));
        System.out.println();
    }

    public List<String> winners() {
        int maxPosition = results.values().stream()
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new);

        return results.entrySet().stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(entry -> entry.getKey().getName())
                .toList();
    }
}
