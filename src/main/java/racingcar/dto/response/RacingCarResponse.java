package racingcar.dto.response;

import racingcar.domain.Car;

import java.util.List;

public record RacingCarResponse(
        List<Car> racingCars
) {
    public static RacingCarResponse from(List<Car> racingCars) {
        return new RacingCarResponse(racingCars);
    }
}
