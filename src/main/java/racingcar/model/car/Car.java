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

    public String name() {
        return name.value();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(movingStrategy, car.movingStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, movingStrategy);
    }
}
