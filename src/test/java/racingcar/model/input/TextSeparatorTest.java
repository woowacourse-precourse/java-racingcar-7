package racingcar.model.input;

import static org.junit.jupiter.api.Assertions.*;

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
}