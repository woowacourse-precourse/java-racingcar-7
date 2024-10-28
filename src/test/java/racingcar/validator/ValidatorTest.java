package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.Letter.*;
import static racingcar.constant.Number.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	private Validator validator;
	
	@BeforeEach
	void setUp() {
		validator = Validator.getInstance();
	}
	
	@Test
	@DisplayName("유효한 자동차 이름 목록 입력을 배열로 변환")
	void testStringToArray_validInput() {
		String input = "aaa,bbb,ccc";
		String[] result = validator.stringToArray(input);
		
		assertThat(result).containsExactly("aaa", "bbb", "ccc");
	}
	
	@Test
	@DisplayName("예외: 잘못된 구분자가 포함된 자동차 이름 목록 입력")
	void testStringToArray_invalidSeparator() {
		String input = "aaa;bbb;ccc";
		
		assertThatThrownBy(() -> validator.stringToArray(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(COMMA.toString());
	}
	
	@Test
	@DisplayName("예외: 자동차 이름이 길이 제한을 초과")
	void testStringToArray_nameExceedsMaxLength() {
		String input = "veryLongCarName,bbb,ccc";
		
		assertThatThrownBy(() -> validator.stringToArray(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(MAX_LENGTH.toString());
	}
	
	@Test
	@DisplayName("유효한 숫자 입력을 long으로 변환")
	void testStringToLong_validInput() {
		String input = "5";
		long result = validator.stringToLong(input);
		
		assertThat(result).isEqualTo(5);
	}
	
	@Test
	@DisplayName("예외: 문자가 포함된 시도 횟수 입력")
	void testStringToLong_invalidInput() {
		String input = "five";
		
		assertThatThrownBy(() -> validator.stringToLong(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("숫자");
	}
}
