package racingcar.car;

import racingcar.util.Separator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarFactory {

    private final Separator separator = new Separator();

    public List<Car> createCars(String carNames) {
        return Stream.of(separator.separate(carNames))
                .map(Car::new)
                .collect(Collectors.toList());
        
    }

}
