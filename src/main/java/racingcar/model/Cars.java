package racingcar.model;

import java.util.Comparator;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Cars(cars);
    }

    public void race() {
        cars.forEach(Car::race);
    }

    public List<String> getCarsInformation() {
        return cars.stream().map(Car::getInformation).toList();
    }

    public List<String> determineWinners() {
        int maxStatus = getMaximumStatus();
        return cars.stream().filter(car -> car.getStatus() == maxStatus)
                .map(Car::getName).toList();
    }

    private int getMaximumStatus() {
        return cars.stream().max(Comparator.comparingInt(Car::getStatus))
                .get().getStatus();
    }
}
