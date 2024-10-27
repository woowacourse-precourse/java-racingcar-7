package racingcar;

import static racingcar.RacingConstants.CAR_START_POSITION;

import java.util.Comparator;
import java.util.List;

public class Judge {
    private final List<CurrentCar> currentCars;

    public Judge(List<CurrentCar> currentCars) {
        this.currentCars = currentCars;
    }

    public Integer findMaxPosition() {
        return currentCars.stream()
                .map(CurrentCar::position)
                .max(Comparator.naturalOrder())
                .orElse(CAR_START_POSITION);
    }
}