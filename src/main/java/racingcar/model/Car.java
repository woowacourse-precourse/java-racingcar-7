package racingcar.model;

import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_EXCEPTION;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String name;
    private long position = 0;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getPosition() {
        return position;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.message());
        }
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        return getRandomNumber() >= 4;
    }

    protected int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(this.name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car o) {
        return Long.compare(this.position, o.position);
    }
}
