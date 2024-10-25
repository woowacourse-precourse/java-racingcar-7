package racingcar.exception.name;

import racingcar.exception.GlobalException;

public class NameException extends GlobalException {
	public NameException(NameExceptionMessage message) {
		super(message.getMessage());
	}
}
