package racingcar.executor.mover;

import racingcar.entity.Car;
import racingcar.executor.decider.movement.RandomMovementDecider;
import racingcar.executor.generator.movement.RandomIntegerGenerator;

import java.util.List;

public class CarMoverImpl implements CarMover {

    private final RandomMovementDecider randomMovementDecider;

    public CarMoverImpl(RandomMovementDecider randomMovementDecider) {
        this.randomMovementDecider = randomMovementDecider;
    }

    @Override
    public List<Car> run(List<Car> currentHistory) {
        for (Car car : currentHistory) {
            if (randomMovementDecider.decide(RandomIntegerGenerator.run()))
               car.move();
        }
        return currentHistory;
    }
}
