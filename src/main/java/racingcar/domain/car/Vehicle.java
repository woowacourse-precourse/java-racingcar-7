package racingcar.domain.car;

import racingcar.domain.strategy.Strategy;

public interface Vehicle {

    boolean canMoveForwardRandomly();

    Vehicle moveForwardRandomly();

    Name getName();

    Position getPosition();

    Strategy getStrategy();
}
