package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StageResult {

    private final Map<Car, Integer> results;

    public StageResult(List<Car> cars) {
        this.results = cars.stream()
                .collect(HashMap::new, (map, car) ->
                        map.put(car, car.getPosition()), HashMap::putAll);
    }

    public void print() {
        results.forEach((car, position) ->
                System.out.println(car.getName() + " : " + "-".repeat(position)));
        System.out.println();
    }
}
