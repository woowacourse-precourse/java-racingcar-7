package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatingParserTest {

	@DisplayName("쉼표로 구분된 문자열을 분리하여 자동차 이름 목록을 반환한다.")
	@Test
	void parseValidatedCarNames() {
		//given
		ValidatingParser validatingParser = ValidatingParser.create();
		String input = "roy,hana,frod";
		List<String> expect = List.of("roy", "hana", "frod");

		//when
		List<String> result = validatingParser.parseValidatedCarNames(input);

		//then
		assertThat(result).isEqualTo(expect);
	}

	@DisplayName("자동차 이름이 한개라면 IllegalArgumentException 예외가 발생한다.")
	@ParameterizedTest
	@CsvSource({
		"roy",
		"hana"
	})
	void parseValidatedCarNamesSizeIsOne(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.create();

		//when & then
		assertThatThrownBy(() -> validatingParser.parseValidatedCarNames(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 이름에 빈 문자열이 있으면 IllegalArgumentException 예외가 발생한다.")
	@ParameterizedTest
	@CsvSource({
		"roy,",
		"roy, ,frod",
		"roy,hana,"
	})
	void parseValidatedCarNamesEmptyString(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.create();

		//when & then
		assertThatThrownBy(() -> validatingParser.parseValidatedCarNames(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException 예외가 발생한다.")
	@ParameterizedTest
	@CsvSource({
		"roy123,hana123,frod123",
		"roy,hana12,frod"
	})
	void parseValidatedCarNamesOverLength(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.create();

		//when & then
		assertThatThrownBy(() -> validatingParser.parseValidatedCarNames(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("시도 횟수를 숫자로 반환한다.")
	@Test
	void validateAttemptCount() {
		//given
		ValidatingParser validatingParser = ValidatingParser.create();
		String input = "5";
		int expect = 5;

		//when
		int result = validatingParser.validateAttemptCount(input);

		//then
		assertThat(result).isEqualTo(expect);
	}

	@DisplayName("시도 횟수가 숫자가 아니면 IllegalArgumentException 예외가 발생한다.")
	@ParameterizedTest
	@CsvSource({
		"a",
		"#",
		"abceef"
	})
	void validateAttemptCountNotNumber(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.create();

		//when & then
		assertThatThrownBy(() -> validatingParser.validateAttemptCount(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("시도 횟수가 양수가 아니면 IllegalArgumentException 예외가 발생한다.")
	@ParameterizedTest
	@CsvSource({
		"-1",
		"0"
	})
	void validateAttemptCountNotPositiveNumber(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.create();

		//when & then
		assertThatThrownBy(() -> validatingParser.validateAttemptCount(input))
			.isInstanceOf(IllegalArgumentException.class);
	}
}