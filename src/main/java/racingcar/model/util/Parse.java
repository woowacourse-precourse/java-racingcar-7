package racingcar.model.util;

import racingcar.model.domain.Delimiter;

public class Parse {
	private final Delimiter delimiter;

	public Parse(Delimiter delimiter) {
		this.delimiter = delimiter;
	}

	public static int parseToInt(String attemptNumber) {
		return Integer.parseInt(attemptNumber);
	}
}