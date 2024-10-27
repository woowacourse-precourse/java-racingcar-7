package racingcar.dto;

import racingcar.domain.Car;

public record RaceResultResponse(String name, int distance) {
	public RaceResultResponse(Car car) {
		this(car.getName(), car.getDistance());
	}
}
