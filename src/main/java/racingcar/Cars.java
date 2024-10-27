package racingcar;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public void createCars(String carNames) {
        List<String> names = Arrays.asList(carNames.split(","));
        carList = names.stream()
                .map(name -> new Car(name.trim()))
                .toList();
    }

    public void moveAllCars() {
        carList.forEach(Car::move);
    }

    private int findMaxPosition() {
        return carList.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<Car> findWinner() {
        int maxPosition = findMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<String> collectAllStatuses() {
        return carList.stream()
                .map(Car::displayStatus)
                .toList();
    }
}
