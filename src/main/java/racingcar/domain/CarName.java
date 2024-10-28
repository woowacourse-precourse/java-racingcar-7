package racingcar.domain;

import java.util.List;

public class CarName {
	private final List<String> carNames;

	private CarName(List<String> carNames) {
		this.carNames = carNames;
	}

	public static CarName from(List<String> carNames) {
		return new CarName(carNames);
	}

	public void isCarNameLengthValid() {
		for (String carName : carNames) {
			if (isCarNameTooLong(carName)) {
				throw new IllegalArgumentException("5자 미만의 이름을 입력해 주세요.");
			}
		}
	}

	private boolean isCarNameTooLong(String car) {
		return car.length() > 4;
	}

	public boolean hasOnlyOneCar() {
		return carNames.size() == 1;
	}

	public boolean doesNotEnterCarName() {
		return carNames.get(0).equals("");
	}

	public List<String> getCarNames() {
		return carNames;
	}
}
