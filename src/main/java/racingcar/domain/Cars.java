package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String carsNames) {
        String[] splitNames = carsNames.split(",");
        cars = Arrays.stream(splitNames)
                .map(name -> new Car(name.strip()))
                .toList();
    }
}
