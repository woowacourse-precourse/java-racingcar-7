package racingcar;

import java.util.List;

public class CarNameParser {
	private static final String DELIMITER = ",";
	private CarValidator carValidator;

	public List<String> parseCarNameList(String carNames) {
		return splitCarNameList(carNames).stream()
				.map(carValidator::validateNameEmpty)
				.map(carValidator::validateCarNameLimit)
				.toList();
	}

	private List<String> splitCarNameList(String carNameList) {
		return List.of(carNameList.split(DELIMITER));
	}
}
