package racingcar.model;

import racingcar.validator.CarValidator;

import java.util.Objects;

public class Car implements Comparable<Car> {
    public static final int INITIAL_POSITION = 0;
    public static final int MOVEABLE_POWER = 4;
    public static final String COLON = " : ";
    public static final String MOVE_BAR = "-";

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
        CarValidator.validateCar(name);
    }

    public void move(int power) {
        if (power >= MOVEABLE_POWER) {
            position++;
        }
    }

    public String getRoundResult() {
        return name + COLON + MOVE_BAR.repeat(position);
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car compareCar) {
        return Integer.compare(compareCar.position, this.position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Car car)) {
            return false;
        }

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}