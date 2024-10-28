package racingcar.model.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.model.message.ErrorMessage.INVALID_CAR_NAMES_INPUT;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextSeparatorTest {

	@Test
	@DisplayName("자동차 이름을 쉼표를 기준으로 구분하여 반환할 수 있다.")
	void 자동차_이름을_쉼표를_기준으로_구분하여_리스트를_반환한다() {
		// given
		String input = "pobi,chan";
		List<String> expectedResult = List.of("pobi", "chan");

		// when
		List<String> carNames = TextSeparator.separateCarNames(input);

		// then
		assertEquals(expectedResult, carNames);
	}

	@Test
	@DisplayName("자동차 이름에 중복이 있는 경우 에러를 발생시킨다.")
	void 자동차_이름에_중복이_있을_때_예외가_발생한다() {
		// given
		String input = "pobi,chan,chan";

		// when, then
		assertThatThrownBy(() -> TextSeparator.separateCarNames(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(INVALID_CAR_NAMES_INPUT.getMessage());
	}
}