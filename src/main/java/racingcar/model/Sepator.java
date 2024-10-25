package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sepator {
    public List<Car> separateCars(String input) {
        final String DELIMITER = ",";
        List<Car> cars = new ArrayList<>();

        String[] splitInput =  input.split(DELIMITER);
        for (String element : splitInput) {
            cars.add(new Car(element));
        }
        return cars;
    }
}
