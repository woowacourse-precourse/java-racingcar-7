package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameData {
    private final List<Car> cars;
    private final int attempts;

    public GameData(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public List<Car> getWinnerCars() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        // 우승자를 필터링하여 반환
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }


}
