package racingcar.front.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericValidatorTest {

    @Test
    @DisplayName("문자열이 숫자를 가지고 있는지 검증")
    void 문자열_숫자_검증_테스트() {
        //given
        String numberString = "32";
        boolean expectedBoolean = true;
        //when
        boolean isNumber = NumericValidator.isNaturalNumber(numberString);
        //then
        assertThat(isNumber).isEqualTo(expectedBoolean);
    }

    @Test
    @DisplayName("문자열이 숫자를 가지고 있지 않을 때 false 반환")
    void 문자열_숫자_검증_예외_테스트() {
        //given
        String numberString = "32as";
        boolean expectedBoolean = false;
        //when
        boolean isNumber = NumericValidator.isNaturalNumber(numberString);
        //then
        assertThat(isNumber).isEqualTo(expectedBoolean);
    }
}