package racingcar.exception;

public class GlobalException extends IllegalArgumentException {
	private static final String ERROR_PREFIX = "[ERROR]";

	public GlobalException(String message) {
		super(ERROR_PREFIX + message);
	}
}
