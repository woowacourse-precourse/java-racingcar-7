package racingcar.parser;

import java.util.Set;

public class CarNameInputParser {
	public Set<String> parseInput(String input) {
		String[] carNames = input.split(",");

		return Set.of(carNames);
	}

	private void validateParticipantCount(String[] carNames) {
		if (carNames.length < 2) {
			throw new IllegalArgumentException("[ERROR] 참가자는 2명 이상이어야 합니다.");
		}
	}
}
