package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest{

    @Test
    void 문자가_입력된_경우() {
        //given
        String value = "abc";
        String expected = "정수 값이 아닙니다: " + value;
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidator.isNumericValue(value));

        //then

        assertThat(e.getMessage()).isEqualTo(expected);
    }

    @Test
    void 공백문자가_입력된_경우() {
        //given
        String value = " ";
        String expected = "정수 값이 아닙니다: " + value;
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidator.isNumericValue(value));

        //then

        assertThat(e.getMessage()).isEqualTo(expected);
    }

    @Test
    void null_문자가_입력된_경우() {
        //given
        String value = null;
        String expected = "정수 값이 아닙니다: " + value;
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidator.isNumericValue(value));

        //then

        assertThat(e.getMessage()).isEqualTo(expected);
    }
    @Test

    void 기호_문자가_입력된_경우() {
        //given
        String value = ";.";
        String expected = "정수 값이 아닙니다: " + value;
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidator.isNumericValue(value));

        //then

        assertThat(e.getMessage()).isEqualTo(expected);
    }

    @Test
    void 음의_정수가_입력_된_경우() {
        //given
        String value = "-3";
        String expected = "양의 정수 값이 아닙니다: " + value;
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidator.isPositiveInteger(value));

        //then

        assertThat(e.getMessage()).isEqualTo(expected);
    }

    @Test
    void 숫자_0이_입력_된_경우() {
        //given
        String value = "0";
        String expected = "양의 정수 값이 아닙니다: " + value;
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> NumberValidator.isPositiveInteger(value));

        //then

        assertThat(e.getMessage()).isEqualTo(expected);
    }

}