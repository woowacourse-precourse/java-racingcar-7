package racingcar.dto;

import racingcar.domain.Car;

public record CarDto(String name, int position) {

    public CarDto(Car car) {
        this(car.getName(), car.getPosition());
    }
}
