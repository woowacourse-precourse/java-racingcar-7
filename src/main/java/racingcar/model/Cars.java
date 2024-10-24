package racingcar.model;

import java.util.Comparator;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        cars.forEach(Car::race);
    }

    public List<String> getCarsInformation() {
        return cars.stream().map(Car::getInformation).toList();
    }

    public List<String> determineWinners() {
        int maxStatus = cars.stream().max(Comparator.comparingInt(Car::getStatus))
                .get().getStatus();

        List<String> winnersName = cars.stream().filter(car -> car.getStatus() == maxStatus).map(Car::getName).toList();
        return winnersName;
    }
}
