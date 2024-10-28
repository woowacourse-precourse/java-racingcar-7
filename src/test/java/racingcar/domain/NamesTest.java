package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.name.Name;
import racingcar.domain.name.Names;
import racingcar.exception.name.NameException;

public class NamesTest {

	@Test
	@DisplayName("Names 객체가 올바르게 생성된다.")
	public void createNames() {
		List<Name> carNames = List.of(new Name("pobi"), new Name("jun"));
		Names names = new Names(carNames);

		assertInstanceOf(Names.class, names);
	}

	@Test
	@DisplayName("중복된 이름이 존재하면 오류를 발생시킨다.")
	public void throwExceptionDuplicateNames() {
		List<Name> carNames = List.of(new Name("pobi"), new Name("jun"), new Name("pobi"));
		assertThrows(NameException.class, ()-> new Names(carNames));
	}
}
