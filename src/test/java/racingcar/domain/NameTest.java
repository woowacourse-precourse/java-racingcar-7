package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.name.Name;
import racingcar.exception.name.NameException;

public class NameTest {
	@Test
	@DisplayName("Name 객체를 올바르게 생성한다.")
	public void createName() {
		String value = "hong";

		Name name = new Name(value);

		assertInstanceOf(Name.class, name);
	}

	@Test
	@DisplayName("5글자 초과의 이름은 오류를 발생시킨다.")
	public void throwExceptionWhenNameLengthOver5() {
		String value = "siiiix";

		assertThrows(NameException.class, () -> new Name(value));
	}

	@Test
	@DisplayName("이름은 공백일 수 없다.")
	public void throwExceptionWhenNameIsBlank() {
		String value = "";

		assertThrows(NameException.class, () -> new Name(value));
	}
}
