package racingcar.model;

import java.util.List;

public class RacingCars {

    private final List<RacingCar> values;

    public RacingCars(List<RacingCar> values) {
        validateDuplication(values);
        this.values = List.copyOf(values);
    }

    private void validateDuplication(List<RacingCar> values) {
        if (values.stream().distinct().count() != values.size()) {
            throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
        }
    }
}
