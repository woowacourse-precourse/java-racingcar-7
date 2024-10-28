package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static List<Car> createCars(List<String> names){
        return names.stream().map(Car::new).collect(Collectors.toList());
    }
}
