package racingcar.dto;

import racingcar.model.Car;

import java.util.List;

public record RacingGameDto(List<Car> cars, int tryCount) {
}
