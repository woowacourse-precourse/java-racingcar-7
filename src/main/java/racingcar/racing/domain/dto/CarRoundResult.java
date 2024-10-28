package racingcar.racing.domain.dto;

import racingcar.racing.domain.Car;

public record CarRoundResult(String carName, int currentDistance) {
    public static CarRoundResult from(Car car) {
        return new CarRoundResult(car.getName(), car.getTotalDistance());
    }
}
