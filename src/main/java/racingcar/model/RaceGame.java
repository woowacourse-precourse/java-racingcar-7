package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private final List<Car> cars;
    private final int attempts;

    public RaceGame(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void moveAll(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateRandomNumber());
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public int getAttempts() {
        return attempts;
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
