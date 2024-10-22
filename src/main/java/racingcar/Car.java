package racingcar;


import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private String position;

    private Car(String name) {
        this.name = name;
        this.position = "";
    }
    public static List<Car> generateCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
