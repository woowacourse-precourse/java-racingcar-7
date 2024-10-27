package racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(RandomNumberGenerator randomNumberGenerator) {
        cars.forEach(car -> car.move(randomNumberGenerator.move()));
    }

    public Map<String, Integer> getResult() {
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }


}
