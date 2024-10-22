package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_COUNT = 1;

    private final CarName carName;
    private int position = DEFAULT_POSITION;

    public Car(String carName) {
        this(new CarName(carName));
    }

    private Car(CarName carName) {
        this.carName = carName;
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.position += MOVE_COUNT;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName.getCarName();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return position == car.position && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
