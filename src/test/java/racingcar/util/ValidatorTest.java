package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;

class ValidatorTest {

	private Validator validator;

	@BeforeEach
	void setUp() {
		validator = new Validator();
	}

	@Test
	@DisplayName("자동차 이름 유효성 검사")
	void testCheckCarNamesWithValidNames() {
		// Arrange
		ArrayList<String> carNames = new ArrayList<>(Arrays.asList("CarA", "CarB", "CarC"));

		// Act & Assert
		validator.checkCarNames(carNames);
	}

	@Test
	@DisplayName("유효하지 않은 자동차 이름일 시 예외 발생")
	void testCheckCarNamesWithEmptyName() {
		// Arrange
		ArrayList<String> carNames = new ArrayList<>(Arrays.asList("CarA", "", "CarC"));

		// Act & Assert
		assertThatThrownBy(() -> validator.checkCarNames(carNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
	}

	@Test
	@DisplayName("5자를 초과한 자동차 이름일 시 예외 발생")
	void testCheckCarNamesWithLongName() {
		// Arrange
		ArrayList<String> carNames = new ArrayList<>(Arrays.asList("CarA", "LongCarName", "CarC"));

		// Act & Assert
		assertThatThrownBy(() -> validator.checkCarNames(carNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.INVALID_CAR_NAME.getMessage());
	}

	@Test
	@DisplayName("유효한 이동 시도 횟수 검사")
	void testCheckRaceCountWithValidCount() {
		// Arrange
		int raceCount = 5;

		// Act & Assert
		validator.checkRaceCount(raceCount);
	}

	@Test
	@DisplayName("유효하지 않은 이동 시도 횟수(음수)일 시 예외 발생")
	void testCheckRaceCountWithNegativeCount() {
		// Arrange
		int raceCount = -1;

		// Act & Assert
		assertThatThrownBy(() -> validator.checkRaceCount(raceCount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.INVALID_RACE_COUNT.getMessage());
	}

	@Test
	@DisplayName("유효하지 않은 이동 시도 횟수(0)일 시 예외 발생")
	void testCheckRaceCountWithZeroCount() {
		// Arrange
		int raceCount = 0;

		// Act & Assert
		assertThatThrownBy(() -> validator.checkRaceCount(raceCount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.INVALID_RACE_COUNT.getMessage());
	}

	@Test
	@DisplayName("유효하지 않은 이동 시도 횟수(범위 초과)일 시 예외 발생")
	void testCheckRaceCountWithExceedingCount() {
		// Arrange
		int raceCount = 101;

		// Act & Assert
		assertThatThrownBy(() -> validator.checkRaceCount(raceCount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.INVALID_RACE_COUNT.getMessage());
	}

	@Test
	void checkCarCountShouldNotThrowException() {
		// Arrange
		List<String> carNames = Arrays.asList("CarA", "CarB", "CarC", "CarD", "CarE",
			"CarF", "CarG", "CarH", "CarI", "CarJ",
			"CarK", "CarL", "CarM", "CarN", "CarO",
			"CarP", "CarQ", "CarR", "CarS", "CarT"); // 20개

		// Act & Assert
		assertThatNoException().isThrownBy(() -> validator.checkCarCount(carNames));
	}

	@Test
	void checkCarCountShouldThrowException() {
		// Arrange
		List<String> carNames = Arrays.asList("CarA", "CarB", "CarC", "CarD", "CarE",
			"CarF", "CarG", "CarH", "CarI", "CarJ",
			"CarK", "CarL", "CarM", "CarN", "CarO",
			"CarP", "CarQ", "CarR", "CarS", "CarT",
			"CarU"); // 21개

		// Act & Assert
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> validator.checkCarCount(carNames))
			.withMessage(ErrorMessage.EXCEED_CAR_COUNT.getMessage());
	}
}
