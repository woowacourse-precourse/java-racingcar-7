package racingcar.executor.calculator.distance;

import racingcar.executor.decider.movement.RandomMovementDecider;

import java.util.Map;

public class MoveDistanceCalculatorImpl implements MoveDistanceCalculator {

    private final RandomMovementDecider randomMovementDecider;

    public MoveDistanceCalculatorImpl(RandomMovementDecider randomMovementDecider) {
        this.randomMovementDecider = randomMovementDecider;
    }

    @Override
    public Map<String, Integer> calculateDistance(Map<String, Integer> currentHistory) {
        for (String carName : currentHistory.keySet()) {
            if (randomMovementDecider.decide())
               currentHistory.put(carName, currentHistory.get(carName) + 1);
        }
        return currentHistory;
    }
}
