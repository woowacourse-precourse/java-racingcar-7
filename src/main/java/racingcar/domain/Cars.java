package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carsInput) {
        this.carList = carsInput;
    }

    public List<Car> getClonedCars() {
        List<Car> clonedcarList = carList.stream()
                .map((car) -> new Car(car.getName(), car.getState()))
                .collect(Collectors.toUnmodifiableList());

        return clonedcarList;
    }

    public void race(NumberGenerator numberGenerator) {
        carList.stream()
                .forEach(car -> car.act(numberGenerator.generateNumber()));
    }

    public String findWinnerNames() {
        int maxDistance = findMaxDistance();

        List<Car> winnerList = filterWinners(maxDistance);

        String winnerNames = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        return winnerNames;
    }

    private List<Car> filterWinners(int maxDistance) {
        return carList.stream()
                .filter((car) -> car.getDistance() == maxDistance)
                .toList();
    }

    private int findMaxDistance() {
        Car winner = carList.stream()
                .max(Comparator.comparing(car -> car.getDistance()))
                .orElseThrow(NullPointerException::new);

        return winner.getDistance();
    }
}
