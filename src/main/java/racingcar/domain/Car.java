package racingcar.domain;

import java.util.Comparator;

public class Car implements Comparator<Car> {
    private final String name;
    private Integer position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    @Override
    public String toString() {
        return name+" : "+ "-".repeat(position);
    }

    @Override
    public int compare(Car o1, Car o2) {
        return o1.position - o2.position;
    }

    public void forward() {
        this.position++;
    }

    public Integer getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
