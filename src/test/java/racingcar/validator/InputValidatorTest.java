package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @DisplayName("공백이 아닌 문자열을 입력할 때 결과 값은 False다.")
    @Test
    void resultIsTrueWhenInputIsNotBlank() {
        // given
        String inputCarNames = "pobi";

        // when
        boolean result = inputValidator.isInputEmpty(inputCarNames);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("공백 문자열을 입력할 때 결과 값은 True다.")
    @Test
    void resultIsTrueWhenInputIsBlank() {
        // given
        String inputCarNames = " ";

        // when
        boolean result = inputValidator.isInputEmpty(inputCarNames);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("입력 값이 Null일 때 결과 값은 True다.")
    @Test
    void resultIsTrueWhenInputIsNull() {
        // given
        String inputCarNames = null;

        // when
        boolean result = inputValidator.isInputEmpty(inputCarNames);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("모든 이름의 글자 수가 5자 이하일 때 결과 값은 True다.")
    @Test
    void resultIsTrueWhenAllInputLenIsFiveOrLess() {
        // given
        String[] names = new String[]{"pobi", "alis", "bamin"};

        // when
        boolean result = inputValidator.validCarNameLength(names);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("모든 이름 중 하나의 이름이 5자 초과일 때 결과 값은 False다.")
    @Test
    void resultIsFalseWhenAnyInputNameExceedFive() {
        // given
        String[] names = new String[]{"pobi", "alis", "youngtae"};

        // when
        boolean result = inputValidator.validCarNameLength(names);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("정상적인 양수 문자를 입력할 때 정수형 값으로 변환된다.")
    @Test
    void convertToIntegerFromStringWhenInputIsPositiveNumber() {
        // given
        String input = "123";

        // when
        int validatedNumber = inputValidator.getValidatedRacingAttempt(input);

        // then
        assertThat(validatedNumber).isInstanceOf(Integer.class);
    }

    @DisplayName("숫자로 변환 불가능한 문자를 입력할 때 에외가 발생한다..")
    @Test
    void throwsExceptionWhenInputIsNotANumber() {
        // given
        String input = "abc";

        // when  // then
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.getValidatedRacingAttempt(input));
    }

    @DisplayName("음수를 입력할 때 에외가 발생한다.")
    @Test
    void throwsExceptionWhenInputIsNegative() {
        // given
        String input = "-5";

        // when  // then
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.getValidatedRacingAttempt(input));
    }
}