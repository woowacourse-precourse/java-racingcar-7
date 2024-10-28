package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

class InputTest {

	@AfterEach
	void closeConsole() {
		Console.close();
	}

	@Test
	@DisplayName("시도 횟수를 입력하면 해당 숫자가 반환된다.")
	void normal_readTurn_number() {
		// given
		System.setIn(createUserInput("7"));

		// when, then
		Assertions.assertThat(Input.readTurn()).isEqualTo(7);
	}

	@Test
	@DisplayName("시도 횟수에 숫자를 입력하지 않은 경우 예외가 발생한다.")
	void notNumber_readTurn_exception() {
		// given
		System.setIn(createUserInput("a"));

		// when, then
		Assertions.assertThatThrownBy(Input::readTurn)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("숫자를 입력해주세요.");
	}


	private InputStream createUserInput(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}
}
