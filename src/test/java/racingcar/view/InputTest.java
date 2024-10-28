package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

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

	@Test
	@DisplayName("자동차 이름을 ','로 구분하여 입력하면 문자열 목록이 반환된다.")
	void normal_readCarNames_strings() {
		// given
		System.setIn(createUserInput("car1,car2,car3"));

		// when, then
		Assertions.assertThat(Input.readCarNames()).isEqualTo(List.of("car1", "car2", "car3"));
	}

	@Test
	@DisplayName("자동차 이름 간의 공백문자는 무시하고 문자열 목록이 반환된다.")
	void namesBetweenBlank_readCarNames_strings() {
		// given
		System.setIn(createUserInput("car1, car2, car3"));

		// when, then
		Assertions.assertThat(Input.readCarNames()).isEqualTo(List.of("car1", "car2", "car3"));
	}

	@Test
	@DisplayName("구분자를 기준으로 빈문자열일 경우 예외가 발생한다.")
	void blankCarName_readCarNames_exception() {
		// given
		System.setIn(createUserInput("car1, ,car3"));

		// when, then
		Assertions.assertThatThrownBy(Input::readCarNames)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름을 빈 값 없이 입력해주세요.");
	}

	@Test
	@DisplayName("빈문자열을 입력할 경우 예외가 발생한다.")
	void blank_readCarNames_exception() {
		// given
		System.setIn(createUserInput(" "));

		// when, then
		Assertions.assertThatThrownBy(Input::readCarNames)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름을 하나 이상 입력해주세요.");
	}

	private InputStream createUserInput(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}
}
