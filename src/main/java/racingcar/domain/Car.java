package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name.trim();
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position ++;
    }

    public static List<Car> createCarsFromInput(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

}
