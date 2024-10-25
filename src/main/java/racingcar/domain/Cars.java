package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow();

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();
    }

    public void playRound() {
        cars.forEach(Car::playRound);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addAllByName(List<String> carNames) {
        carNames.forEach(name ->
            cars.add(new Car(name))
        );
    }
}
