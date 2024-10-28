package racingcar.Domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        CarsValidator.validate(names);
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return getWinnersByPosition(maxPosition);
    }

    private List<String> getWinnersByPosition(int maxPosition) {
        List<Car> winningCars = getWinningCars(maxPosition);
        return extractWinnerNames(winningCars);
    }

    private List<Car> getWinningCars(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private List<String> extractWinnerNames(List<Car> winningCars) {
        return winningCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}