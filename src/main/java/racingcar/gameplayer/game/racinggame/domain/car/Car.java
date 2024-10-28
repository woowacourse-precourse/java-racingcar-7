package racingcar.gameplayer.game.racinggame.domain.car;

import racingcar.gameplayer.game.racinggame.domain.car.strategy.random.MovingStrategy;
import racingcar.gameplayer.game.racinggame.domain.car.strategy.random.RandomMovingStrategy;

public class Car {

    private final Name name;
    private Position position;
    private final MovingStrategy strategy;
    private static final MovingStrategy DEFAULT_MOVING_STRATEGY = new RandomMovingStrategy();

    public Car(Name name) {
        this(name, DEFAULT_MOVING_STRATEGY);
    }

    public Car(Name name, MovingStrategy strategy) {
        this.name = name;
        this.position = Position.ZERO;
        this.strategy = strategy;
    }

    public void move() {
        position = position.add(strategy.getDistance());
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
