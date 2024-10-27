package racingcar.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new ArrayList<>();
        addToCars(carNames);
    }

    public void incrementDistance() {
        for (Car car : this.cars) {
            car.incrementDistance();
        }
    }

    public Map<String, Integer> getInformation() {
        Map<String, Integer> carsInfo = new HashMap<>();
        for (Car car : this.cars) {
            carsInfo.put(car.getName(), car.getDistance());
        }
        return carsInfo;
    }

    public List<String> getWinners() {
        int maxDistance = findMaxDistance();
        return findWinnersByDistance(maxDistance);
    }

    private int findMaxDistance() {
        return this.cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    private List<String> findWinnersByDistance(int maxDistance) {
        return this.cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void addToCars(List<String> carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName.trim()));
        }
    }
}