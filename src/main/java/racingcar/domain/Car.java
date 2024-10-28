package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private Long distance;
    public static final int FORWARDING_CONDITION = 4;

    public Car(String name) {
        this.name = name;
        this.distance = 0L;
    }

    public Long getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void execute(final int command) {
        if (command >= FORWARDING_CONDITION) {
            this.distance++;
        }
    }

    public boolean hasSameDistanceWith(Car anotherCar) {
        return Objects.equals(this.distance, anotherCar.distance);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.name).append(" : ");
        for (int i = 0; i < this.distance; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    @Override
    public int compareTo(Car car) {
        int comparison = -1 * Long.compare(this.distance, car.distance);
        if (comparison == 0) {
            return this.name.compareTo(car.name);
        }
        return comparison;
    }
}
