package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomNumberGeneratorTest {

	private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

	@Test
	void 랜덤_숫자_범위_테스트() {
		int randomNumber = randomNumberGenerator.generateRandomNumber();
		assertTrue(randomNumber >= 0 && randomNumber <= 9);
	}
}