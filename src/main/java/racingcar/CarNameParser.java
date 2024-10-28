package racingcar;

import java.util.List;

public class CarNameParser {
	private static final String DELIMITER = ",";
	private final CarValidator carValidator;

	public CarNameParser() {
		this.carValidator = new CarValidator();
	}

	public List<String> parse(String input) {
		List<String> carNames = splitCarNames(input);
		return carValidator.validateCarNameList(carNames);
	}

	private List<String> splitCarNames(String carNameList) {
		return List.of(carNameList.split(DELIMITER));
	}
}
