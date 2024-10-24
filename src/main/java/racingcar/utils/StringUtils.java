package racingcar.utils;

public class StringUtils {

	private StringUtils() {
	}

	public static int toNumber(String s) {
		validateNotEmpty(s);
		validateNumber(s);
		return Integer.parseInt(s);
	}

	public static void validateNotEmpty(String s) {
		if (s.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	private static void validateNumber(String s) {
		for (char ch : s.toCharArray()) {
			if (!Character.isDigit(ch)) {
				throw new IllegalArgumentException();
			}
		}
	}
}
