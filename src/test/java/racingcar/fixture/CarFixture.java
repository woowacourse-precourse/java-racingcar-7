package racingcar.fixture;

import racingcar.domain.Car;

public enum CarFixture {
	SEI("sei"),
	POBI("pobi"),
	RED("red"),
	;
	private final String name;

	CarFixture(String name) {
		this.name = name;
	}

	public Car toCar() {
		return Car.create(name);
	}

	public enum CreateFailFixture {
		EMPTY(""),
		LONG_NAME("a".repeat(6)),
		;
		private final String name;

		CreateFailFixture(String name) {
			this.name = name;
		}

		public Car toCar() {
			return Car.create(name);
		}
	}
}
