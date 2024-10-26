package racingcar.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(String carsInput) {
        this.cars = CarsFactory.makeCarList(carsInput);
    }

    public List<Car> getClonedCars() {
        List<Car> clonedCars=cars.stream()
                .map((car)->new Car(car.getName(),car.getState()))
                .collect(Collectors.toUnmodifiableList());

        return clonedCars;
    }

    public void race(NumberGenerator numberGenerator) {
        cars.stream()
                .forEach(car -> car.act(numberGenerator.generateNumber()));
    }

    public String findWinners() {
        int maxDistance = findMaxDistance();

        List<Car> winnerList = filterWinners(maxDistance);

        String winnerNames = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        return winnerNames;
    }

    private List<Car> filterWinners(int maxDistance) {
        return cars.stream()
                .filter((car) -> car.getDistance() == maxDistance)
                .toList();
    }

    private int findMaxDistance() {
        Car winner = cars.stream()
                .max(Comparator.comparing(car -> car.getDistance()))
                .orElseThrow(NullPointerException::new);

        return winner.getDistance();
    }
}
