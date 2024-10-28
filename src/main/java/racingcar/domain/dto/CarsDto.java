package racingcar.domain.dto;

import java.util.Collections;
import java.util.List;

public class CarsDto {
    private final List<CarDto> cars;

    public CarsDto(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
