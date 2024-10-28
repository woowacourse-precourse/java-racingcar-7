package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Race {
    private final List<Car> cars;
    private final int attempts;

    public Race(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void startRace(Consumer<String> roundResultConsumer) {
        for (int i = 0; i < attempts; i++) {
            String roundResult = getRoundResult();
            roundResultConsumer.accept(roundResult);
        }
    }

    private String getRoundResult() {
        StringBuilder roundResult = new StringBuilder();
        for (Car car : cars) {
            car.move();
            roundResult.append(car).append("\n");
        }
        return roundResult.toString();
    }

    public List<String> getWinners() {
        int maxDistance = findMaxDistance();
        return findWinners(maxDistance);
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    private List<String> findWinners(int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
