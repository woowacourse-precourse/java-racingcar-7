package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Separator {
	public static List<String> separateComma(String participants) {
		return Arrays.stream(participants.split(",")).toList();
	}
}
