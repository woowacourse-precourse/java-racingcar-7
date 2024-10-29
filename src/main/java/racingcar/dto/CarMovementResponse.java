package racingcar.dto;

import racingcar.domain.Car;

public record CarMovementResponse(String name, int distance) {
	public CarMovementResponse(Car car) {
		this(car.getName(), car.getDistance());
	}
}
