package racingcar;

import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
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
