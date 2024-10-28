package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private final Map<String, Integer> carProgressMap;

    public Map<String, Integer> getCarProgressMap() {
        return carProgressMap;
    }

    public Race(List<String> racersNames) {
        carProgressMap = new LinkedHashMap<>();
        for (String racerName : racersNames) {
            carProgressMap.put(racerName, 0);
        }
    }

    public void displayCarProgress() {
        carProgressMap.forEach((name, distance) ->
                System.out.println(name + " : " + "-".repeat(distance))
        );
    }
}
