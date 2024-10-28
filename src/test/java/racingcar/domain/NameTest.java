package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("NameTest")
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
}