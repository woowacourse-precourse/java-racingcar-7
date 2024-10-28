package racingcar.parser;

import java.util.Arrays;
import java.util.List;

public class CarNameInputParser {
	public List<String> parseInput(String input) {
		String[] carNames = input.split(",");
		validateParticipantCount(carNames);
		validateUniqueName(carNames);

		return List.of(carNames);
	}

	private void validateParticipantCount(String[] carNames) {
		if (carNames.length < RaceConfig.MIN_PARTICIPANT_COUNT.getNumber()) {
			throw new IllegalArgumentException("[ERROR] 참가자는 최소 2명 이상이어야 합니다.");
		}
	}

	private void validateUniqueName(String[] carNames) {
		if (hasDuplicateNames(carNames)) {
			throw new IllegalArgumentException("[ERROR] 차량 이름은 중복되지 않아야 합니다.");
		}
	}

	private boolean hasDuplicateNames(String[] carNames) {
		return Arrays.stream(carNames)
			.distinct()
			.count() != carNames.length;
	}
}
