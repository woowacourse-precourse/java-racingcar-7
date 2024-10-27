package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @DisplayName("공백이 아닌 문자열을 입력할 때 예외가 발생하지 않는다.")
    @Test
    void doesNotThrowExceptionWhenInputIsNotBlank() {
        // given
        String inputCarNames = "pobi";

        // when     // then
        assertDoesNotThrow(() -> inputValidator.isInputEmpty(inputCarNames));
    }

    @DisplayName("공백 문자열을 입력할 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenInputIsBlank() {
        // given
        String inputCarNames = " ";

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.isInputEmpty(inputCarNames));

        assertThat(exception.getMessage()).isEqualTo("경주할 자동차 이름을 입력해주세요.");
    }

    @DisplayName("입력 값이 Null일 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenInputIsNull() {
        // given
        String inputCarNames = null;

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.isInputEmpty(inputCarNames));

        assertThat(exception.getMessage()).isEqualTo("경주할 자동차 이름을 입력해주세요.");
    }

    @DisplayName("모든 이름의 글자 수가 5자 이하일 때 예외가 발생하지 않는다.")
    @Test
    void doesNotThrowExceptionWhenAllInputLenIsFiveOrLess() {
        // given
        String[] names = new String[]{"pobi", "alis", "bamin"};

        // when     // then
        assertDoesNotThrow(() -> inputValidator.validCarNameLength(names));
    }

    @DisplayName("모든 이름 중 하나의 이름이 5자 초과일 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenAnyInputNameExceedFive() {
        // given
        String[] names = new String[]{"pobi", "alis", "youngtae"};

        // when     // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validCarNameLength(names));

        assertThat(exception.getMessage()).isEqualTo("자동차 이름은 최대 5글자 입니다.");
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
        assertThat(validatedNumber).isEqualTo(123);
    }

    @DisplayName("숫자로 변환 불가능한 문자를 입력할 때 에외가 발생한다..")
    @Test
    void throwsExceptionWhenInputIsNotANumber() {
        // given
        String input = "abc";

        // when  // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.getValidatedRacingAttempt(input));

        assertThat(exception.getMessage()).isEqualTo("1이상의 양수를 입력해주세요.");
    }

    @DisplayName("음수를 입력할 때 에외가 발생한다.")
    @Test
    void throwsExceptionWhenInputIsNegative() {
        // given
        String input = "-5";

        // when  // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.getValidatedRacingAttempt(input));

        assertThat(exception.getMessage()).isEqualTo("1이상의 양수를 입력해주세요.");
    }
}