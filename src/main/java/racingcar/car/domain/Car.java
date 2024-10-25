package racingcar.car.domain;

import racingcar.car.service.dto.CarCreateReqDto;

public class Car {
	private String name;

	private Integer position;

	private Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public String getName() {
		return name;
	}

	public Integer getPosition() {
		return position;
	}

	public void move() {
		this.position += 1;
	}

	public static Car from(CarCreateReqDto reqDto) {
		return new Car(reqDto.getCarName());
	}
}
