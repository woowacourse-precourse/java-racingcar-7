package racingcar.model.output;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerResultGeneratorTest {

	@Test
	@DisplayName("단일 우승자일 때, 결과 문자열을 생성할 수 있다.")
	void 단일_우승자가_담긴_결과_문자열을_생성한다() {
		// given
		String winnerName = "winner";
		List<String> winner = List.of(winnerName);

		// when
		String winnerResult = WinnerResultGenerator.generateWinnerResult(winner);

		// then
		assertEquals(winnerName, winnerResult);
	}
}