package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings =  {"2d", "yy", "#4", "한글","   ", " "})
    @DisplayName("시도 횟수 입력시 숫자가 아닌값 입력시 IllegalArgumentException() 예외처리")
    void validateNotNumber(String inputString) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() ->Validator.validateNotNumber(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도횟수는 양수만 입력할 수 있습니다.");

    }


    @Test
    @Disabled
    @DisplayName("시도 횟수 입력시 빈값 또는 0 입력시 IllegalArgumentException() 예외처리")
    void validateEmptyOrZeroString() {
    }

    @Test
    @Disabled
    @DisplayName("이름 입력시 이름길이가 5자 초과시 IllegalArgumentException()예외처리")
    void validateNameLength() {
    }

    @Test
    @Disabled
    @DisplayName("이름 입력시 이름포맷(영문, 숫자, '_') 이외 문자 입력시 IllegalArgumentException() 예외처리")
    void validateNameFormat() {
    }
}