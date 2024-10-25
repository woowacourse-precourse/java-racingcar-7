package racingcar.model.car;

import racingcar.model.number.MoveNumber;
import racingcar.model.name.Name;
import racingcar.strategy.Strategy;

import java.util.Objects;

public class Car {
    private final Name name;
    private final MoveNumber moveNumber;

    public Car(String name) {
        this(new Name(name), new MoveNumber(0));
    }

    public Car(String name, int number) {
        this(new Name(name), new MoveNumber(number));
    }

    public Car(Name name, MoveNumber moveNumber) {
        this.name = name;
        this.moveNumber = moveNumber;
    }

    public void move(Strategy strategy) {
        this.moveNumber.move(strategy.random());
    }

    public String getName() {
        return name.getName();
    }

    public int getMoveNumber() {
        return moveNumber.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(moveNumber, car.moveNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveNumber);
    }

}
