package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionCode;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesInputValidatorTest {

    @Test
    @DisplayName("',' 기준으로 이름 입력값 유효성 검사")
    void validateSuccess() {
        assertThatCode(() -> NamesInputValidator.validate("123,12345"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("',' 사이 공백 무관")
    void validateBlankSuccess() {
        assertThatCode(() -> NamesInputValidator.validate(" 123, 1234 "))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 공백일 경우 예외 발생")
    void validateBlank() {
        assertThatThrownBy(() -> NamesInputValidator.validate(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionCode.INPUT_BLANK.message());
    }

    @Test
    @DisplayName("차 이름이 1개일 경우 예외 발생")
    void validateOnlyOneName() {
        assertThatThrownBy(() -> NamesInputValidator.validate("ab/c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionCode.CAR_SHORTAGE.message());
    }

    @Test
    @DisplayName("중복된 차 이름이 있을 경우 예외 발생")
    void validateDistinctName() {
        assertThatThrownBy(() -> NamesInputValidator.validate("ab,ab , c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionCode.NAME_DUPLICATED.message());
    }

    @Test
    @DisplayName("5자 이상의 이름이 존재할 경우 예외 발생")
    void validateLongNames() {
        assertThatThrownBy(() -> NamesInputValidator.validate("abcdefg,hijk"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionCode.NAME_TOO_LONG.message());
    }
}