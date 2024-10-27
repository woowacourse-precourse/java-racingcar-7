package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@DisplayName("여러개의 무작위 값을 생성할 수 있다.")
	@Test
	void generateBy() {
		// given
		int min = 10;
		int max = 20;
		int numberCount = 30;

		// when
		List<Integer> randomNumbers = RandomNumberGenerator.generateBy(min, max, numberCount);

		// then
		assertThat(randomNumbers).hasSize(30)
			.allMatch(randomNumber -> randomNumber >= min && randomNumber <= max);
	}
}