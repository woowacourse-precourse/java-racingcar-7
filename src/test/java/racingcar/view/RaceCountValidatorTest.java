package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.RaceCountValidator;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RaceCountValidatorTest {
	private final RaceCountValidator raceCountValidator = new RaceCountValidator();

	@Test
	void 이동_횟수는_0보다_커야한다() {
		assertThrows(IllegalArgumentException.class, () -> raceCountValidator.getRounds("0"));
	}

	@Test
	void 이동_횟수는_숫자여야한다() {
		assertThrows(IllegalArgumentException.class, () -> raceCountValidator.getRounds("a"));
	}
}