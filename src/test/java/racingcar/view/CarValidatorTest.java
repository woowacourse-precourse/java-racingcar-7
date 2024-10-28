package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.CarNameParser;
import racingcar.CarValidator;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarValidatorTest {

	private CarNameParser carNameParser;
	private CarValidator carValidator;

	@Test
	void 자동차_이름은_1자에서_5자_사이여야_한다() {
		String carNames = "alicealice";
		List<String> parsedCarNames = carNameParser.parse(carNames);
		assertThrows(IllegalArgumentException.class, ()
				-> carValidator.validateCarNameLimit(parsedCarNames.getFirst()));
	}

	@Test
	void 자동차_이름은_공백일_수_없다() {
		String carNames = "";
		List<String> parsedCarNames = carNameParser.parse(carNames);
		assertThrows(IllegalArgumentException.class, ()
				-> carValidator.validateNameEmpty(parsedCarNames.getFirst()));
	}
}