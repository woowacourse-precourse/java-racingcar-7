package racingcar.dto;

import racingcar.domain.Cars;

public class GameDataDto {
    private final Cars cars;
    private final Integer gameCount;

    public GameDataDto(Cars cars, Integer gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }
}
