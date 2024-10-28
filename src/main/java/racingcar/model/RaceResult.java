package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private final List<Car> winners;

    public RaceResult(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        this.winners = cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }

    public List<String> getWinnersNames() {
        return winners.stream().map(Car::getName).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "최종 우승자 : " + String.join(", ", getWinnersNames());
    }
}
