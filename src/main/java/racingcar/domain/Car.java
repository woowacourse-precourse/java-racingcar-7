package racingcar.domain;

import java.util.Objects;
import racingcar.commander.MovementCommander;

public class Car {

    private final String name;
    private final Position position;

    public Car(String name, Position position) {
        if (isInvalid(name)) {
            throw new IllegalArgumentException("이름의 길이는 6을 넘길 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public Car(String name, int position) {
        this(name, new Position(position));
    }

    public Car(String name) {
        this(name, Position.defaultInstance());
    }

    private boolean isInvalid(String name) {
        return isBlank(name) || isTooLong(name);
    }

    private boolean isBlank(String name) {
        return name.isBlank();
    }

    private boolean isTooLong(String name) {
        return 6 <= name.length();
    }

    public Car move(MovementCommander movementCommander) {
        MoveCommand command = movementCommander.moveCommand();
        return command.execute(this, new CarMoveCommandExecutor());
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return position.value();
    }

    public boolean samePosition(int position) {
        return this.position.equalsTo(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    private static class CarMoveCommandExecutor implements MoveCommandExecutor<Car> {

        @Override
        public Car move(Car car) {
            Position position = car.position;
            return new Car(car.name, position.increase());
        }
    }
}
