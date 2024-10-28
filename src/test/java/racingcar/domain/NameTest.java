package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 이름 테스트")
class NameTest {
	@Test
	@DisplayName("빈 자동차 이름을 입력할 경우, 예외를 반환한다.")
	void Throw_Exception_When_Car_Name_Blank() {
		// given
		String input = "";

		// when, then
		assertThatThrownBy(() -> new Name(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(CAR_NAME_BLANK.getMessage());
	}

	@Test
	@DisplayName("자동차 이름이 최대 길이를 초과할 경우, 예외를 반환한다.")
	void Throw_Exception_When_Car_Name_Length_Exceeded() {
		// given
		String input = "holyPigeon";

		// when, then
		assertThatThrownBy(() -> new Name(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(CAR_NAME_LENGTH_EXCEEDED.getMessage());
	}

	@Test
	@DisplayName("자동차 이름에 알파벳이 아닌 다른 문자가 있는 경우, 예외를 반환한다.")
	void Throw_Exception_When_Car_Name_Not_Alphabet() {
		// given
		String input = "비둘기";

		// when, then
		assertThatThrownBy(() -> new Name(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(CAR_NAME_NOT_ALPHABET.getMessage());
	}
}