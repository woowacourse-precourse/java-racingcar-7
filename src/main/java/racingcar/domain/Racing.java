package racingcar.domain;

import java.util.LinkedHashSet;
import java.util.List;

public record Racing(LinkedHashSet<RacingCar> cars, int tryCount) {

    public static Racing of(LinkedHashSet<RacingCar> cars, int tryCount) {
        return new Racing(cars, tryCount);
    }

    public List<RacingCar> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> isSameMaxPosition(car, maxPosition))
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream().mapToInt(RacingCar::getPosition).max().orElse(Integer.MIN_VALUE);
    }

    private boolean isSameMaxPosition(RacingCar car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }
}
