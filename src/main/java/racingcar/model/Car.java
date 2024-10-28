package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static List<Car> createCars(String carNames) {
        List<String> names = Arrays.asList(carNames.split(","));

        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }

        return cars;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveIfPossible(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }
}
