package racingcar.model;

import java.util.List;

public class RacingCars {

    private final List<RacingCar> values;

    public RacingCars(List<RacingCar> values) {
        this.values = List.copyOf(values);
    }
}
