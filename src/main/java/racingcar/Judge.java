package racingcar;

import static racingcar.RacingConstants.INITIAL_MOVE_COUNT;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {
    private final List<CurrentCar> currentCars;

    public Judge(List<CurrentCar> currentCars) {
        this.currentCars = currentCars;
    }

    public String getWinnerNames() {
        return currentCars.stream()
                .filter(car -> findMaxMoveCount().equals(car.moveCount()))
                .map(CurrentCar::carName)
                .collect(Collectors.joining(", "));
    }

    private Integer findMaxMoveCount() {
        return currentCars.stream()
                .map(CurrentCar::moveCount)
                .max(Comparator.naturalOrder())
                .orElse(INITIAL_MOVE_COUNT);
    }
}