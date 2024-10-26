package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<String> names) {
        List<Car> cars = names.stream().map(Car::getInstance).toList();
        this.cars = cars;
    }

    public static Cars getInstance(String input) {
        return new Cars(Arrays.stream(input.split(",")).toList());
    }

    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }
}
