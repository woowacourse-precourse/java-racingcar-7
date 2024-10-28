package racingcar.executor.mover;

import racingcar.entity.Car;
import racingcar.executor.decider.movement.RandomMovementDecider;
import racingcar.executor.generator.movement.RandomIntegerGenerator;

import java.util.List;

public class AllCarMoverImpl implements AllCarMover {

    private final RandomMovementDecider randomMovementDecider;

    public AllCarMoverImpl(RandomMovementDecider randomMovementDecider) {
        this.randomMovementDecider = randomMovementDecider;
    }

    @Override
    public List<Car> run(List<Car> currentHistory) {
        for (Car car : currentHistory) {
            if (randomMovementDecider.decide(RandomIntegerGenerator.runZeroToNine()))
               car.move();
        }
        return currentHistory;
    }
}
