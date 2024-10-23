package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCarTrace {
    private final Map<RacingCar, Integer> trace = new LinkedHashMap<>();

    public void put(RacingCar racingCar) {
        trace.put(racingCar, 0);
    }
}
