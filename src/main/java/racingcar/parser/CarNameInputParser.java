package racingcar.parser;

import java.util.Set;

public class CarNameInputParser {
	public Set<String> parseInput(String input) {
		String[] carNames = input.split(",");

		return Set.of(carNames);
	}
}
