package racingcar.car.service;

import racingcar.constant.ErrorStatus;

public class CarService {

	private void isValidName(String name) {
		if (name.length() > 5)
			throw new IllegalArgumentException("자동차의 이름이 5자를 넘습니다.");
	}

	private void isPossibleCount(Integer count) {
		if (count > 10000 || count <= 0)
			throw new IllegalArgumentException(ErrorStatus.INVALID_NUMBER_RANGE.getMessage());
	}
}
