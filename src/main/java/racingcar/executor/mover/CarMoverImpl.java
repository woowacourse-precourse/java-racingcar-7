package racingcar.executor.mover;

import racingcar.executor.decider.movement.RandomMovementDecider;
import racingcar.executor.generator.movement.RandomIntegerGenerator;

import java.util.Map;

public class CarMoverImpl implements CarMover {

    private final RandomMovementDecider randomMovementDecider;

    public CarMoverImpl(RandomMovementDecider randomMovementDecider) {
        this.randomMovementDecider = randomMovementDecider;
    }

    @Override
    public Map<String, Integer> run(Map<String, Integer> currentHistory) {
        for (String carName : currentHistory.keySet()) {
            if (randomMovementDecider.decide(RandomIntegerGenerator.run()))
               currentHistory.put(carName, currentHistory.get(carName) + 1);
        }
        return currentHistory;
    }
}
