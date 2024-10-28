package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.dto.CarDto;

public class Game {
    private final List<Car> cars;
    private final int totalRounds;
    private int completedRounds;

    public Game(List<Car> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
        this.completedRounds = 0;
    }

    public boolean hasRemainingRounds() {
        return completedRounds < totalRounds;
    }

    public void playOneRound() {
        cars.forEach(Car::moveIfPossible);
        completedRounds++;
    }

    public List<CarDto> getCars() {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getLocation()))
                .toList();
    }

    public List<String> getWinnerNames() {
        int maxLocation = getMaxLocation();
        return cars.stream()
                .filter(car -> car.isAtLocation(maxLocation))
                .map(Car::getName)
                .toList();
    }

    private int getMaxLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }
}