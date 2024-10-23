package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;

import java.util.*;

public class RacePosition {
    private final List<Car> carList;

    public RacePosition(List<Car> carList) {
        validateDuplicateCarName(carList);
        this.carList = carList;
    }

    private void validateDuplicateCarName(List<Car> carList) {
        List<CarName> carNameList = carList.stream()
                .map(Car::getName)
                .toList();
        if (hasDuplicate(carNameList)) {
            throw new IllegalArgumentException("has duplicate car name : " + carNameList.toString());
        }
    }

    private boolean hasDuplicate(List<CarName> carNameList) {
        Set<CarName> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() != carNameList.size();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car findByCarName(CarName carName) {
        return carList.stream()
                .filter(car -> car.getName().equals(carName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("found no Car with name : " + carName.getIdentifier()));
    }

    public List<Car> findFarthestCar() {
        Car farthest = carList.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new NoSuchElementException("found no farthest car"));
        return carList.stream()
                .filter(car -> car.compareTo(farthest) == 0)
                .toList();
    }
}