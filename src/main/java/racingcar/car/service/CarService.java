package racingcar.car.service;

public class CarService {

	private void isValidName(String name) {
		if (name.length() > 5)
			throw new IllegalArgumentException("자동차의 이름이 5자를 넘습니다.");
	}
}
