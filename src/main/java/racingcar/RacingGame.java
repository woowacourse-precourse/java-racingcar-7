package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final List<RoundResult> roundResults;

    public RacingGame(List<String> carNames) {
        this.cars = Car.createCars(carNames);
        this.roundResults = new ArrayList<>();
    }

    public void play(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            recordCurrentRound();
        }
    }

    private void recordCurrentRound() {
        RoundResult roundResult = RoundResult.recordRound(cars);
        roundResults.add(roundResult);
    }

    public List<String> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::currentPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.currentPosition() == maxPosition)
                .map(Car::currentName)
                .collect(Collectors.toList());
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
}