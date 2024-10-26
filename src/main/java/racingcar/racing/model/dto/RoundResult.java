package racingcar.racing.model.dto;

import racingcar.racing.model.Car;

public record RoundResult(String carName, int currentDistance) {
    public static RoundResult from(Car car) {
        return new RoundResult(car.getName(), car.getTotalDistance());
    }
}
