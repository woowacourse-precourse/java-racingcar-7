package racingcar.racinggame.io.input.validation;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

	@DisplayName("사용자는 자동차 이름을 구분자로 구분해 입력해야 한다")
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

	@Test
	void validateTryCount() {
	}
}