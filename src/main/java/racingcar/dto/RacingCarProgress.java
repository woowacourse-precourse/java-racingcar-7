package racingcar.dto;

import racingcar.domain.Car;

public record RacingCarProgress(
        String carName,
        int score
) {
    public static RacingCarProgress of(final Car car) {
        return new RacingCarProgress(
                car.getName(),
                car.getScore()
        );
    }
}
