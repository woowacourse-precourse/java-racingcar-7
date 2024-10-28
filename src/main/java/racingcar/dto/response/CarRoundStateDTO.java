package racingcar.dto.response;

import racingcar.domain.model.Car;

public record CarRoundStateDTO(
        String name,
        Integer moveCount
) {
    public static CarRoundStateDTO from(Car car) {
        return new CarRoundStateDTO(car.getName(), car.getMoveCount());
    }
}
