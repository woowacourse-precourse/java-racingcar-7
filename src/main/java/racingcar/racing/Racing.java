package racingcar.racing;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public interface Racing {
	static Racing getInstance(final String[] nameArr) {
		return new RacingImpl(getNameMap(nameArr));
	}
	
	void printResult(final long tryingCount);
	void printWinner();
	
	private static Map<String, StringBuilder> getNameMap(final String[] nameArr) {
		return Arrays.stream(nameArr)
				.collect(Collectors.toMap(name -> name, name -> new StringBuilder()));
	}
}
