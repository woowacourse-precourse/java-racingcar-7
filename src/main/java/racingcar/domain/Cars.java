package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.power.PowerGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public void move(PowerGenerator powerGenerator) {
        cars.forEach(car -> car.move(powerGenerator.generatorPower()));
    }

    public String getForwardStatuses() {
        return cars.stream()
                .map(Car::forwardStatus)
                .collect(Collectors.joining("\n"));
    }

}
