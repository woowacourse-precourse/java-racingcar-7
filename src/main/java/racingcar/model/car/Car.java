package racingcar.model.car;

import java.util.Objects;
import racingcar.model.game.strategy.MovingStrategy;

public class Car {

    private final Name name;
    private final MovingStrategy movingStrategy;

    public Car(final String name, final MovingStrategy movingStrategy) {
        this.name = new Name(name);
        this.movingStrategy = movingStrategy;
    }

    public boolean doesMove() {
        return movingStrategy.canMove();
    }

    public Name name() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car other = (Car) o;
        return Objects.equals(name, other.name) && Objects.equals(movingStrategy, other.movingStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, movingStrategy);
    }
}
