package racingcar.model.input;

import java.util.List;

public class TextSeparator {

	private static final String DELIMITER = ",";

	public static List<String> separateCarNames(String text) {
		return List.of(text.split(DELIMITER));
	}
}
