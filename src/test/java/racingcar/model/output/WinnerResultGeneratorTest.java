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

	@Test
	@DisplayName("다수 우승자일 때, 결과 문자열을 생성할 수 있다.")
	void 다수_우승자가_담긴_결과_문자열을_생성한다() {
		// given
		String winnerName1 = "winner1";
		String winnerName2 = "winner2";
		List<String> winner = List.of(winnerName1, winnerName2);
		String separator = ", ";
		String expectedResult = winnerName1 + separator + winnerName2;

		// when
		String winnerResult = WinnerResultGenerator.generateWinnerResult(winner);

		// then
		assertEquals(expectedResult, winnerResult);
	}
}