package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorMessage;

import java.util.List;

class ParserTest {

	private Parser parser;

	@BeforeEach
	void setUp() {
		parser = new Parser();
	}

	@Test
	@DisplayName("유효한 문자열을 리스트로 파싱")
	void testStringToListWithValidInput() {
		// Arrange
		String input = "CarA,CarB,CarC";

		// Act
		List<String> result = parser.stringToList(input);

		// Assert
		assertThat(result).containsExactly("CarA", "CarB", "CarC");
	}

	@Test
	@DisplayName("유효하지 않은 문자열(빈 값) 리스트로 파싱 시 예외 처리")
	void testStringToListWithEmptyInput() {
		// Act & Assert
		assertThatThrownBy(() -> parser.stringToList(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
	}

	@Test
	@DisplayName("유효하지 않은 문자열(null) 리스트로 파싱 시 예외 처리")
	void testStringToListWithNullInput() {
		// Act & Assert
		assertThatThrownBy(() -> parser.stringToList(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
	}

	@Test
	@DisplayName("유효한 문자열을 정수로 파싱")
	void testStringToIntWithValidInput() {
		// Arrange
		String input = "5";

		// Act
		int result = parser.stringToInt(input);

		// Assert
		assertThat(result).isEqualTo(5);
	}

	@Test
	@DisplayName("유효하지 않은 문자열(빈 값) 정수로 파싱 시 예외 처리")
	void testStringToIntWithEmptyInput() {
		// Act & Assert
		assertThatThrownBy(() -> parser.stringToInt(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.EMPTY_RACE_COUNT.getMessage());
	}

	@Test
	@DisplayName("유효하지 않은 문자열(null) 정수로 파싱 시 예외 처리")
	void testStringToIntWithNullInput() {
		// Act & Assert
		assertThatThrownBy(() -> parser.stringToInt(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.EMPTY_RACE_COUNT.getMessage());
	}

	@Test
	@DisplayName("유효하지 않은 문자열(문자) 정수로 파싱 시 예외 처리")
	void testStringToIntWithInvalidInput() {
		// Act & Assert
		assertThatThrownBy(() -> parser.stringToInt("invalid"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.INVALID_RACE_COUNT.getMessage());
	}

	@Test
	@DisplayName("유효하지 않은 문자열(소수) 정수로 파싱 시 예외 처리")
	void testStringToIntWithDecimalInput() {
		// Act & Assert
		assertThatThrownBy(() -> parser.stringToInt("5.5"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.INVALID_RACE_COUNT.getMessage());
	}

}
