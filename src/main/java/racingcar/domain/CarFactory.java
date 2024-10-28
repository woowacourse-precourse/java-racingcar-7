package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> createCars(List<Name> names, NumberGenerator NumberGenerator) {
        return names.stream()
                .map(name -> new Car(name, NumberGenerator))
                .collect(Collectors.toList());
    }
}
