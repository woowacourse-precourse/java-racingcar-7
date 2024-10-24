package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> cars) {
        addCars(cars);
    }

    private void addCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void raceGame() {
        for (Car car : cars) {
            car.move(new RandomNumberGenerator());
        }
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    public List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }

    private List<String> findWinner(List<Car> cars) {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}
