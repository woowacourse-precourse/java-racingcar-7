package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<Car> cars;
    private final List<RacingHistory> roundHistory = new ArrayList<>();

    private Racing(List<Car> cars) {
        this.cars = cars;
    }

    public static Racing of(List<Car> cars) {
        return new Racing(cars);
    }

    public void start() {
        runRound();
        record();
    }

    public void printHistory() {
        String history = roundHistory.stream()
                .map(it -> it.joinHistory("\n"))
                .collect(Collectors.joining("\n\n"));

        System.out.println(history);
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

    private void record() {
        roundHistory.add(RacingHistory.of(cars));
    }

    private int findLongDistance() {
        return cars.stream()
                .map(Car::getDistance)
                .max(Integer::compare)
                .orElse(0);
    }
}
