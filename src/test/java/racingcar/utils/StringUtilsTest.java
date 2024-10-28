package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {
	@DisplayName("문자열이 비어있지 않으면 예외를 던지지 않는다.")
	@ParameterizedTest
	@ValueSource(strings = {"a", "sei,pobi"})
	void validateNotEmptySuccessTest(String s) {
		assertThatCode(() -> StringUtils.validateNotEmpty(s))
			.doesNotThrowAnyException();
	}

	@DisplayName("문자열이 비어있으면 예외를 던진다.")
	@ParameterizedTest
	@ValueSource(strings = {""})
	void validateNotEmptyFailTest(String s) {
		assertThatThrownBy(() -> StringUtils.validateNotEmpty(s))
			.isInstanceOf(IllegalArgumentException.class);
	}
}