package racingcar.service.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimesValidationTest {

    @DisplayName("빈 문자열 입력 시 IllegalArgumentException 발생")
    @Test
    void 빈_문자열_예외() {
        // given
        String input = "";
        // when, then
        Assertions.assertThatThrownBy(()->TimesValidation.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("null 입력 시 IllegalArgumentException 발생")
    @Test
    void null_입력_예외() {
        // given
        String input = null;
        // when, then
        Assertions.assertThatThrownBy(()->TimesValidation.validateNull(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자 입력 시 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {",", "A", "b", "+","ㅋ"})
    void 문자_입력_예외(String input){
        Assertions.assertThatThrownBy(()->TimesValidation.validateCharacter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("정수가 아닌 숫자 입력 시 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 정수_외의_숫자_입력_예외(int input){
        Assertions.assertThatThrownBy(()->TimesValidation.validateZeroOrNegative(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}