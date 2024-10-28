package racingcar.parser;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CarNameInputParser 클래스 테스트")
class CarNameInputParserTest {

	@Test
	@DisplayName("입력받은 문자열을 쉼표(,)를 기준으로 자르고, 리스트로 반환한다.")
	void parseInput() {
		// given
		String input = "pobi,woni,jun";
		CarNameInputParser carNameInputParser = new CarNameInputParser();

		// when
		List<String> carNames = carNameInputParser.parseInput(input);

		// then
		assertThat(carNames).containsExactly("pobi", "woni", "jun");
	}
}