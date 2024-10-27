package racingcar.dto;

import racingcar.model.car.Car;

import java.util.List;

public record RacingCarResponse(List<Car> cars, List<Car> winCars) {
}
