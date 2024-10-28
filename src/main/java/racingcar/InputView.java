package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<Car> createCars(String inputNames) {
        String[] names = inputNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name.trim()));
        }

        return cars;
    }
}
