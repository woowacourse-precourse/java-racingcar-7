package racingcar.domain;

public class CarValidator {
	private static final int CAR_NAME_MAX_LENGTH = 5;

	public void validateCarName(String carNames){
		if(carNames.length() > CAR_NAME_MAX_LENGTH){
			throw new IllegalArgumentException("차 이름은 5글자를 초과할 수 없습니다.");
		}
	}
}
