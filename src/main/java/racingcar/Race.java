package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

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

    public void moveAllCars() {
        carProgressMap.forEach((name, distance) -> {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                carProgressMap.put(name, distance + 1);
            }
        });
    }

    public void displayCarProgress() {
        carProgressMap.forEach((name, distance) ->
                System.out.println(name + " : " + "-".repeat(distance))
        );
    }
}
