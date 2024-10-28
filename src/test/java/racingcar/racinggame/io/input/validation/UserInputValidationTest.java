package racingcar.racinggame.io.input.validation;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputValidationTest {

	UserInputValidation userInputValidation;

	@BeforeEach
	void setUp() {
		userInputValidation = new UserInputValidation();
	}

	@DisplayName("사용자는 자동차 이름 입력에 빈 문자열은 입력할 수 없다")
	@Test
	void validateInputCarNamesWithBlank() {
		// given
		String blank = " ";
		String delimiter = ",";

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateInputCarNames(blank, delimiter))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("빈 문자열은 입력할 수 없습니다.");
	}

	@DisplayName("사용자는 구분자를 사용하지 않으면 자동차 이름을 입력할 수 없다")
	@Test
	void validateInputCarNamesWithoutDelimiter() {
		// given
		String carNames = "aaa,bbb,ccc";
		String delimiter = ".";

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateInputCarNames(carNames, delimiter))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("2대 이상의 자동차를 쉼표를 이용해 구분해 입력해주세요");
	}

	@DisplayName("사용자는 자동차 이름들을 구분자를 사용해 입력해야 한다")
	@Test
	void validateInputCarNames() {
		// given
		String carNames = "aaa,bbb,ccc";
		String delimiter = ",";

		// when // then
		assertDoesNotThrow(() -> userInputValidation.validateInputCarNames(carNames, delimiter));
	}

	@DisplayName("사용자는 시도 횟수로 빈 문자열을 입력할 수 없다")
	@Test
	void validateTryCountAsBlank() {
		// given
		String inputTryCount = "";

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateTryCount(inputTryCount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("빈 문자열은 입력할 수 없습니다.");
	}

	@DisplayName("사용자는 시도 횟수로 자연수만 입력할 수 있다")
	@ValueSource(strings = {"a", "-1", "0"})
	@ParameterizedTest(name = "{0}은 입력할 수 없습니다")
	void validateTryCountAsNotNumber(String inputTryCount) {

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateTryCount(inputTryCount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("1 이상의 숫자만 입력 가능합니다.");
	}

	@DisplayName("사용자는 시도 횟수를 입력할 수 있다")
	@Test
	void validateTryCount() {

		// given
		String inputTryCount = "123";

		// when // then
		assertDoesNotThrow(() -> userInputValidation.validateTryCount(inputTryCount));
	}
}