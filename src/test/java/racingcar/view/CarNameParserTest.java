package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.CarNameParser;
import racingcar.CarValidator;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarNameParserTest {
	private CarNameParser carNameParser;
	private CarValidator carValidator;

	@BeforeEach
	void setUp() {
		carNameParser = new CarNameParser();
		carValidator = new CarValidator();
	}

	@Test
	void 자동차_이름_리스트는_반점을_기준으로_파싱된다() {
		String carNames = "tom,jerry,alice";
		List<String> parsedCarNames = carNameParser.parse(carNames);
		List<String> originalCarNames = List.of("tom", "jerry", "alice");
		assertEquals(parsedCarNames, originalCarNames);
	}
}