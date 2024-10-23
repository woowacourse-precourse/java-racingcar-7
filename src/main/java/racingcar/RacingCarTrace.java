package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingCarTrace {
    private final Map<RacingCar, Integer> trace = new LinkedHashMap<>();

    public void put(RacingCar racingCar) {
        trace.put(racingCar, 0);
    }

    public void forward(RacingCar racingCar) {
        trace.put(racingCar, trace.get(racingCar) + 1);
    }

    public int getDistance(RacingCar racingCar) {
        return trace.get(racingCar);
    }
}
