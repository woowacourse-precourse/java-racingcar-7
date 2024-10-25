package racingcar.domain.name;

import racingcar.exception.name.NameException;
import racingcar.exception.name.NameExceptionMessage;

public class Name {
	private static final int NAME_LIMIT_LENGTH = 5;
	private final String name;

	public Name(String name) {
		validate(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void validate(String name) {
		if (name.isBlank()) {
			throw new NameException(NameExceptionMessage.NAME_IS_NOT_BLANK);
		}
		if (name.length() > NAME_LIMIT_LENGTH) {
			throw new NameException(NameExceptionMessage.NAME_TOO_LONG);
		}
	}
}
