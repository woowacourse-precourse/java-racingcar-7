package racingcar.parser;

import static racingcar.exception.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;

import racingcar.config.RaceConfig;

public class CarNameInputParser {
	public List<String> parseInput(String input) {
		String[] carNames = input.split(",");
		validateParticipantCount(carNames);
		validateUniqueName(carNames);

		return List.of(carNames);
	}

	private void validateParticipantCount(String[] carNames) {
		if (carNames.length < RaceConfig.MIN_PARTICIPANT_COUNT.getNumber()) {
			throw new IllegalArgumentException(PARTICIPANT_COUNT_NOT_ENOUGH.getMessage());
		}
	}

	private void validateUniqueName(String[] carNames) {
		if (hasDuplicateNames(carNames)) {
			throw new IllegalArgumentException(CAR_NAME_DUPLICATED.getMessage());
		}
	}

	private boolean hasDuplicateNames(String[] carNames) {
		return Arrays.stream(carNames)
			.distinct()
			.count() != carNames.length;
	}
}
