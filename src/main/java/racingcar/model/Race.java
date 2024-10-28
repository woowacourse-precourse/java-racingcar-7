package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.MoveDecider;

public class Race {
    private final Cars cars;
    private final MoveDecider moveDecider;
    private List<String> finalWinners;

    public Race(Cars cars, MoveDecider moveDecider) {
        this.cars = cars;
        this.moveDecider = moveDecider;
    }

    public List<String> getFinalWinners() {
        return finalWinners;
    }

    public List<Car> startRound() {
        List<Car> roundStatus = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (moveDecider.isMovable()) {
                car.move();
            }
            roundStatus.add(car);
        }

        return roundStatus;
    }

    public void determineFinalWinner() {
        List<Car> sortedCars = sortCarsByDistance();
        int maxDistance = sortedCars.getFirst().getDistance();

        finalWinners = sortedCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> sortCarsByDistance() {
        return new ArrayList<>(cars.getCars()).stream()
                .sorted(Comparator.comparingInt(Car::getDistance).reversed())
                .collect(Collectors.toList());
    }
}
