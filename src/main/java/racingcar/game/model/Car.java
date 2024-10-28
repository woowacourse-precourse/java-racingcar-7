package racingcar.game.model;

import java.util.Objects;
import racingcar.game.error.ErrorMessage;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final Counter counter;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.counter = new Counter();
    }

    public void increaseMoveCount() {
        counter.increase();
    }

    public boolean hasMoveCount(int count) {
        return counter.matchesCount(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return counter.getCount();
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH.getDescription());
        }
    }
}