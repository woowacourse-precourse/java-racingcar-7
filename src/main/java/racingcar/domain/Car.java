package racingcar.domain;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private Position position;

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public Car(String carName) {
        this(new CarName(carName), new Position());
    }

    public Car(String carName, int position) {
        this(new CarName(carName), new Position(position));
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            position = position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public boolean isWin(int maxPosition) {
        return position.getPosition() == maxPosition;
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
