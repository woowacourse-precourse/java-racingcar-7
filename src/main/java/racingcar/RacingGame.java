package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;

    public RacingGame(List<Car> cars, int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException("move attempts must be more than 1");
        }
        this.cars = cars;
        this.attempts = attempts;
    }

    public void play() {
        for (int i=0; i<attempts; i++) {
            playRound();
            OutputView.printRoundResult(cars);
        }
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generate();
            car.move(randomNumber);
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
    }
}
