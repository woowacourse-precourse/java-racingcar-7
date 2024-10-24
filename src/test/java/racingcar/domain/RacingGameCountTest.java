package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.racingGame.RacingGameCount;
import racingcar.exception.racingGame.RacingGameException;

public class RacingGameCountTest {
	@Test
	@DisplayName("RacingGameCount 객체가 올바르게 생성된다.")
	public void createRacingGameCount() {
		RacingGameCount racingGameCount = new RacingGameCount("5");

		assertInstanceOf(RacingGameCount.class, racingGameCount);
	}

	@Test
	@DisplayName("문자를 입력하면 오류가 발생한다.")
	public void throwExceptionNotNumber() {
		assertThrows(RacingGameException.class, () -> new RacingGameCount("hi"));
	}

	@Test
	@DisplayName("공백을 입력하면 오류가 발생한다.")
	public void throwExceptionIsBlank() {
		assertThrows(RacingGameException.class, () -> new RacingGameCount(""));
	}

	@Test
	@DisplayName("0보다 작은 숫자를 입력하면 오류가 발생한다.")
	public void throwExceptionLowerThan0() {
		assertThrows(RacingGameException.class, () -> new RacingGameCount("0"));
		assertThrows(RacingGameException.class, () -> new RacingGameCount("-1"));
	}
}
