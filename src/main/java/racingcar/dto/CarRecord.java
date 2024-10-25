package racingcar.dto;

import racingcar.domain.Car;

public record CarRecord(String name, int position) {
    public static CarRecord from(Car car) {
        return new CarRecord(car.getName(), car.getPosition());
    }
}
