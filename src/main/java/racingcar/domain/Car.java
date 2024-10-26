package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.vo.Name;
import racingcar.vo.Position;

public class Car implements Comparable<Car> {
    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car withName(Name name) {
        return new Car(name, Position.initial());
    }

    public void attemptMove(MovingStrategy movingStrategy) {
        boolean canMove = movingStrategy.shouldMove();

        if (canMove) {
            position.forward();
        }
    }

    @Override
    public int compareTo(Car other) {
        return this.position.compareTo(other.position);
    }
}
