package racingcar.model.domain;

import java.util.Arrays;
import java.util.List;

public enum Delimiter {
	COMMA(",");

	private final String delimiter;

	Delimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public List<String> splitCarNames(String carNames) {
		return Arrays.asList(carNames.split(this.delimiter));
	}
}