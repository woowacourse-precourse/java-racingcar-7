package racingcar.domain.racingcar.dto;

import racingcar.domain.racingcar.domain.Car;
import java.util.List;

public class RaceStatus {
    private final List<CarStatus> carStatuses;
    private final int currentRound;
    private final int totalRounds;

    public RaceStatus(List<Car> cars, int currentRound, int totalRounds) {
        this.carStatuses = cars.stream()
                .map(car -> new CarStatus(car.getName(), car.getPosition()))
                .toList();
        this.currentRound = currentRound;
        this.totalRounds = totalRounds;
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public record CarStatus(String name, int position) {
    }
}