package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDomains {
    private final List<CarDomain> carDomainList;

    private CarDomains(List<CarDomain> cars) {
        this.carDomainList = new ArrayList<>(cars);
    }

    public static CarDomains create(List<CarDomain> cars) {
        return new CarDomains(cars);
    }

    public List<CarDomain> getCarDomainList() {
        return new ArrayList<>(carDomainList);
    }

    public CarDomains getWinnersInstance() {
        int maxDistance = getMaxDistance();

        return new CarDomains(carDomainList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList()));
    }

    public void executeOneRound() {
        carDomainList.forEach(CarDomain::attemptMove);
    }

    private int getMaxDistance() {
        return carDomainList.stream()
                .map(CarDomain::getDistance)
                .max(Integer::compare)
                .orElse(0);
    }
}
