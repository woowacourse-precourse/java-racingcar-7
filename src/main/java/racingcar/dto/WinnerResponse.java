package racingcar.dto;

import racingcar.domain.Car;

public record WinnerResponse(String name) {
	public WinnerResponse(Car car) {
		this(car.getName());
	}
}
