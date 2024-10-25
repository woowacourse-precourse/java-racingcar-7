package racingcar.dto;

import racingcar.model.Car;

public record CarDto(String name, long position) {
    public static CarDto from(Car car) {
        return new CarDto(
                car.getName(),
                car.getPosition()
        );
    }
}
