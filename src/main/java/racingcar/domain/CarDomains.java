package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarDomains {
    private final List<CarDomain> cars;

    private CarDomains(List<CarDomain> cars) {
        this.cars = cars;
    }

    public static CarDomains create(List<CarDomain> cars) {
        return new CarDomains(cars);
    }

    public List<CarDomain> getCars() {
        return cars;
    }

    public void add(CarDomain car) {
        cars.add(car);
    }

    public CarDomains getWinnersInstance() {
        int maxDistance = getMaxDistance();

        return new CarDomains(cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList()));
    }

    public void executeOneRound() {
        cars.forEach(CarDomain::attemptMove);
    }

    private int getMaxDistance() {
        return cars.stream()
                .map(CarDomain::getDistance)
                .max(Integer::compare)
                .orElse(0);
    }
}
