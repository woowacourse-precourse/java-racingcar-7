package racingcar.domain.name;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
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
