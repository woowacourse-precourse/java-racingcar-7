package racingcar.service.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesValidationTest {

    @DisplayName("빈 문자열 입력 시 IllegalArgumentException 발생")
    @Test
    void 빈_문자열_예외() {
        // given
        String input = "";
        // when, then
        Assertions.assertThatThrownBy(()->CarNamesValidation.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("null 입력 시 IllegalArgumentException 발생")
    @Test
    void null_입력_예외() {
        // given
        String input = null;
        // when, then
        Assertions.assertThatThrownBy(()->CarNamesValidation.validateNull(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5자를 초과하면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"saliba", "gabriel", "123456"})
    void 이름_5자_초과_예외(String input){
        Assertions.assertThatThrownBy(()->CarNamesValidation.validateOver(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 영어가 아니면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"123", ";;++","서지민"})
    void 이름_영어_아님_예외(String input){
        Assertions.assertThatThrownBy(()->CarNamesValidation.validateEng(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자 사이가 비어있으면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "one,,two,three",
            "ian,delta,,",
            ",,,kevin,ian,sam"
    })
    void 구분자_사이_없음_예외(String input){
        Assertions.assertThatThrownBy(()->CarNamesValidation.validateBetweenDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자가 쉼표가 아니면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "one:two,three",
            "ian,delta,kevin:tom",
            "kevin/dave/bean"
    })
    void 구분자_쉼표_아님_예외(String input){
        Assertions.assertThatThrownBy(()->CarNamesValidation.validateDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}