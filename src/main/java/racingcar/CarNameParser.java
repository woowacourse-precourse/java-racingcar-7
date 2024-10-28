package racingcar;

import java.util.List;

public class CarNameParser {
	private static final String DELIMITER = ",";
	private CarValidator carValidator;

	public List<String> getCarNames(String input) {
		List<String> carNames = splitCarNames(input);
		return carValidator.validateCarNameList(carNames);
	}

	private List<String> splitCarNames(String carNameList) {
		return List.of(carNameList.split(DELIMITER));
	}
}
