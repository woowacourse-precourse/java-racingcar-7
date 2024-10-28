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

class CarValidatorTest {

	private CarValidator carValidator;

	@BeforeEach
	void setUp() {
		carValidator = new CarValidator();
	}

	@Test
	@DisplayName("자동차 이름 유효성 검사")
	void testCheckCarNamesWithValidNames() {
		// Arrange
		ArrayList<String> carNames = new ArrayList<>(Arrays.asList("CarA", "CarB", "CarC"));

		// Act & Assert
		carValidator.checkCarNames(carNames);
	}

	@Test
	@DisplayName("유효하지 않은 자동차 이름일 시 예외 발생")
	void testCheckCarNamesWithEmptyName() {
		// Arrange
		ArrayList<String> carNames = new ArrayList<>(Arrays.asList("CarA", "", "CarC"));

		// Act & Assert
		assertThatThrownBy(() -> carValidator.checkCarNames(carNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
	}

	@Test
	@DisplayName("5자를 초과한 자동차 이름일 시 예외 발생")
	void testCheckCarNamesWithLongName() {
		// Arrange
		ArrayList<String> carNames = new ArrayList<>(Arrays.asList("CarA", "LongCarName", "CarC"));

		// Act & Assert
		assertThatThrownBy(() -> carValidator.checkCarNames(carNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.INVALID_CAR_NAME.getMessage());
	}

	@Test
	void checkCarCountShouldNotThrowException() {
		// Arrange
		List<String> carNames = Arrays.asList("CarA", "CarB", "CarC", "CarD", "CarE",
			"CarF", "CarG", "CarH", "CarI", "CarJ",
			"CarK", "CarL", "CarM", "CarN", "CarO",
			"CarP", "CarQ", "CarR", "CarS", "CarT"); // 20개

		// Act & Assert
		assertThatNoException().isThrownBy(() -> carValidator.checkCarCount(carNames));
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
			.isThrownBy(() -> carValidator.checkCarCount(carNames))
			.withMessage(ErrorMessage.EXCEED_CAR_COUNT.getMessage());
	}
}
