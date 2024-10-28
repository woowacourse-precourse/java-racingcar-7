package racingcar.model.message;

public enum ErrorMessage {

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
