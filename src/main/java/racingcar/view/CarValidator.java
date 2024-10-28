package racingcar.view;

public class CarValidator {
	private static final String DELIMITER = ",";

	public String validateCarNameLimit(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
		return carName;
	}

	public String validateNameEmpty(String carName) {
		if (carName.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
		}
		return carName;
	}
}
