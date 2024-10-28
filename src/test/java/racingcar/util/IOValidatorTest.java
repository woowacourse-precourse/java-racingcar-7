package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class IOValidatorTest {

	@Nested
	class 자동차_입력Test {
		@Test
		void 성공() {
			String input = "pobi, jun, woni";

			assertThatNoException()
					.isThrownBy(() -> IOValidator.validateContainsSeparator(input));
		}

		@ParameterizedTest
		@NullAndEmptySource
		void 실패_null_혹은_빈값(String input) {
			assertThatIllegalArgumentException()
					.isThrownBy(() -> IOValidator.validateContainsSeparator(input));
		}

		@Test
		void 실패_구분자_없음() {
			String input = "pobijun";

			assertThatIllegalArgumentException()
					.isThrownBy(() -> IOValidator.validateContainsSeparator(input));
		}
	}

	@Nested
	class 시도_회수_입력Test {
		@Test
		void 성공() {
			String input = "5";

			assertThatNoException()
					.isThrownBy(() -> IOValidator.validateNaturalNumber(input));
		}

		@ParameterizedTest
		@ValueSource(strings = {"", "kk"})
		void 실패_숫자_아님(String input) {
			assertThatIllegalArgumentException()
					.isThrownBy(() -> IOValidator.validateNaturalNumber(input));
		}

		@ParameterizedTest
		@NullSource
		void 실패_null_입력(String input) {
			assertThatIllegalArgumentException()
					.isThrownBy(() -> IOValidator.validateNaturalNumber(input));
		}

		@Test
		void 실패_자연수_아님() {
			String input = "-1";

			assertThatIllegalArgumentException()
					.isThrownBy(() -> IOValidator.validateNaturalNumber(input));
		}
	}
}
