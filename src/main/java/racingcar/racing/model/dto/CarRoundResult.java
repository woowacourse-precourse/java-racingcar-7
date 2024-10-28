package racingcar.racing.model.dto;

import racingcar.racing.model.Car;

public record CarRoundResult(String carName, int currentDistance) {
    public static CarRoundResult from(Car car) {
        return new CarRoundResult(car.getName(), car.getTotalDistance());
    }
}
