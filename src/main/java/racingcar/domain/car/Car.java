package racingcar.domain.car;

import racingcar.domain.accelerator.Accelerator;
import racingcar.domain.accelerator.RandomAccelerator;
import racingcar.domain.vo.CarName;
import racingcar.domain.vo.Position;

import java.util.Objects;

public class Car {

    private final CarName name;
    private Position position;
    private final Accelerator accelerator;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position(0);
        this.accelerator = new RandomAccelerator();
    }

    public void move(Integer number) {
        if (accelerator.isMovable(number)) {
            this.position = position.move();
        }
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return name.name();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

