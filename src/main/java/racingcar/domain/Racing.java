package racingcar.domain;

import java.util.List;

public class Racing {

    private final CarGroup group;
    private final RacingHistory history;

    public Racing(CarGroup group, RacingHistory history) {
        this.group = group;
        this.history = history;
    }

    public static Racing of(List<Car> cars) {
        return new Racing(CarGroup.of(cars), RacingHistory.of());
    }

    public void start() {
        group.race();
        history.append(group.getStatus());
    }

    public RacingHistory getHistory() {
        return history;
    }

    public List<Car> getWinners() {
        return group.getFarthestCars();
    }
}