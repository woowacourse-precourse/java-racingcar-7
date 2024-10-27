package racingcar.dto.request;

import racingcar.domain.Car;

import java.util.List;

public record RaceRequest(
        List<Car> racingCars,
        int roundNum
) {
    public static RaceRequest of(List<Car> racingCars, int roundNum) {
        return new RaceRequest(racingCars, roundNum);
    }
}