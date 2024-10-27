package racingcar.executor.calculator.distance;

import java.util.Map;

public interface MoveDistanceCalculator {
    Map<String, Integer> calculateDistance(Map<String, Integer> currentHistory);
}
