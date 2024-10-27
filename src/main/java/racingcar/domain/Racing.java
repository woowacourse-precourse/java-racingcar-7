package racingcar.domain;

import java.util.List;
import racingcar.dto.RoundDto;

public class Racing {

    private final List<Car> cars;

    public Racing(List<Car> cars) {
        validate(cars);

        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("차는 1대 이상 존재해야 합니다");
        }
    }

    public void progress() {
        cars.forEach(Car::move);
    }

    public RoundDto getRoundResult() {
        return RoundDto.from(cars);
    }
}
