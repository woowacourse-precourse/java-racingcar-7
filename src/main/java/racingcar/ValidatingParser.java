package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ValidatingParser {

	private ValidatingParser() {
	}

	public static ValidatingParser create() {
		return new ValidatingParser();
	}

	public List<String> parseValidatedCarNames(String inputCarNames) {

		return new ArrayList<>();
	}

	public int validateAttemptCount(String inputAttemptCount) {
		return 0;
	}
}
