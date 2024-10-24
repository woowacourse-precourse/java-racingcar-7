package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Validation {

	public static String carNameDivider = ",";

	/**
	 * 경주할 자동차 이름 입력 확인 메서드
	 * @param input
	 */
	public void validateCarNameInput(String input){

		if(input.startsWith(carNameDivider) || input.endsWith(carNameDivider)){
			throw new IllegalArgumentException("misplaced of comma");
		}

		List<String> carNameList = Arrays.stream(input.split(carNameDivider)).toList();

		for(String carName : carNameList){
			validateCarName(carName);
		}

	}

	private void validateCarName(String carName){
		if(carName.isEmpty() || carName == null) {
			throw new IllegalArgumentException("misplaced of comma");
		}

		if(carName.length() > 5){
			throw new IllegalArgumentException("car name length over 5");
		}
	}

}
