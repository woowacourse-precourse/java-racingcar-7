package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<Car> cars;
    private final List<String> history = new ArrayList<>();

    private Racing(List<Car> cars) {
        this.cars = cars;
    }

    public static Racing of(List<Car> cars) {
        return new Racing(cars);
    }

    public void start() {
        runRound();
        recordHistory();
    }

    public void printHistory() {
        System.out.println(String.join("\n\n", history));
    }

    public List<Car> getWinners() {
        int longDistance = findLongDistance();

        return cars.stream()
                .filter(it -> it.getDistance() == longDistance)
                .collect(Collectors.toList());
    }

    private void runRound() {
        cars.forEach(Car::moveForward);
    }

    private void recordHistory() {
        String roundHistory = cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));

        history.add(roundHistory);
    }

    private int findLongDistance() {
        return cars.stream()
                .map(Car::getDistance)
                .max(Integer::compare)
                .orElse(0);
    }
}
