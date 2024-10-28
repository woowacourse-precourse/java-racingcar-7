package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomGenerator;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> playRound() {
        for (Car car : cars) {
            int randomValue = RandomGenerator.generateRandomNumber();
            car.move(randomValue);
        }
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
          .filter(car -> car.getPosition() == maxPosition)
          .map(Car::getName)
          .collect(Collectors.toList());
    }
}
