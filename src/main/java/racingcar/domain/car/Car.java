package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.car.dto.CarResultDto;

public class Car {
    private final CarName name;
    private final Position position;

    private Car(final String name) {
        this.name = CarName.from(name);
        this.position = Position.create();
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public void move() {
        position.add();
    }

    public boolean isMaxPosition(final int maxPosition) {
        return maxPosition == position.getPosition();
    }

    public CarResultDto getRaceResult() {
        return new CarResultDto(this.getName(), this.getPosition());
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
